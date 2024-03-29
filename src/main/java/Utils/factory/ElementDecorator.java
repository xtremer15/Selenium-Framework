package Utils.factory;

import Utils.WrapperWebElementImpl.WrapperWebElement;
import Utils.WrapperWebElementImpl.WrapperWebElementImpl;
import Utils.annotation.ImplementedBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;


public class ElementDecorator implements FieldDecorator {
    /**
     * factory to use when generating ElementLocator.
     */
    private LocatorFactory factory;
    protected WebDriver driver;

    /**
     * Constructor for an ElementLocatorFactory. This class is designed to replace DefaultFieldDecorator.
     *
     * @param factory for locating elements.
     */
    public ElementDecorator(LocatorFactory factory) {
        this.factory = factory;
    }

    /**
     * Constructor for an ElementLocatorFactory. This class is designed to replace DefaultFieldDecorator.
     *
     * @param factory for locating elements.
     * @param driver  webdriver {@link WebDriver}
     */
    public ElementDecorator(LocatorFactory factory, WebDriver driver) {
        this.factory = factory;
        this.driver = driver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!(WebElement.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
            return null;
        }

        final WebDriver driverRef = driver;

        if (field.getDeclaringClass() == WrapperWebElementImpl.class) {
            return null;
        }

        ElementLocator locator = factory.createLocator(field);
        if (locator == null) {
            return null;
        }

        Class<?> fieldType = field.getType();
        if (WebElement.class.equals(fieldType)) {
            fieldType = WrapperWebElement.class;
        }

        if (WebElement.class.isAssignableFrom(fieldType)) {
            return proxyForLocator(loader, fieldType, locator, driverRef);
        } else if (List.class.isAssignableFrom(fieldType)) {
            Class<?> erasureClass = getErasureClass(field);
            return proxyForListLocator(loader, erasureClass, locator, driverRef);
        } else {
            return null;
        }
    }

    protected <T> List<T> proxyForListLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator, WebDriver driver) {
        final WebDriver driverRef = driver;
        InvocationHandler handler;
        if (interfaceType.getAnnotation(ImplementedBy.class) != null) {
            handler = new ElementListHandler(interfaceType, locator, driverRef);
        } else {
            handler = new LocatingElementListHandler(locator);
        }
        List<T> proxy;
        proxy = (List<T>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);
        return proxy;
    }

    /**
     * Generate a type-parameterized locator proxy for the element in question. We use our customized InvocationHandler
     * here to wrap classes.
     *
     * @param loader    ClassLoader of the wrapping class
     * @param fieldType Interface wrapping the underlying WebElement
     * @param locator   ElementLocator pointing at a proxy of the object on the page
     * @param driver    Webdriver instance
     * @param <T>       The interface of the proxy.
     * @return proxy representing the class we need to wrap.
     */
    protected <T> T proxyForLocator(ClassLoader loader, Class<T> fieldType, ElementLocator locator, WebDriver driver) {
        final WebDriver driverRef = driver;

        InvocationHandler handler = new ElementHandler(fieldType, locator, driverRef);

        T proxy;
        proxy = fieldType.cast(Proxy.newProxyInstance(
                loader, new Class[]{fieldType, WebElement.class, WrapsElement.class, Locatable.class}, handler));
        return proxy;
    }

    private Class<?> getErasureClass(Field field) {
        // Type erasure in Java isn't complete. Attempt to discover the generic
        // interfaceType of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    private boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        Class<?> erasureClass = getErasureClass(field);
        if (erasureClass == null) {
            return false;
        }

        if (!WebElement.class.isAssignableFrom(erasureClass)) {
            return false;
        }

        if (field.getAnnotation(FindBy.class) == null &&
                field.getAnnotation(FindBys.class) == null &&
                field.getAnnotation(FindAll.class) == null) {
            return false;
        }

        return true;
    }

    /**
     * Generate a type-parameterized locator proxy for the element in question. We use our customized InvocationHandler
     * here to wrap classes.
     *
     * @param loader        ClassLoader of the wrapping class
     * @param interfaceType Interface wrapping the underlying WebElement
     * @param locator       ElementLocator pointing at a proxy of the object on the page
     * @param <T>           The interface of the proxy.
     * @return a proxy representing the class we need to wrap.
     */
    protected <T> T proxyForLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator) {
        InvocationHandler handler = new ElementHandler(interfaceType, locator);

        T proxy;
        proxy = interfaceType.cast(Proxy.newProxyInstance(
                loader, new Class[]{interfaceType, WebElement.class, WrapsElement.class, Locatable.class}, handler));
        return proxy;
    }

    /**
     * generates a proxy for a list of elements to be wrapped.
     *
     * @param loader        classloader for the class we're presently wrapping with proxies
     * @param interfaceType type of the element to be wrapped
     * @param locator       locator for items on the page being wrapped
     * @param <T>           class of the interface.
     * @return proxy with the same type as we started with.
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> proxyForListLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator) {
        InvocationHandler handler;
        if (interfaceType.getAnnotation(ImplementedBy.class) != null) {
            handler = new ElementListHandler(interfaceType, locator);
        } else {
            handler = new LocatingElementListHandler(locator);
        }
        List<T> proxy;
        proxy = (List<T>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);
        return proxy;
    }
}
