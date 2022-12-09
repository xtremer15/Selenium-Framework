package Utils.factory;

import Utils.WrapperWebElementImpl.WrapperWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.*;

import static Utils.factory.ImplementedByProcessor.getWrapperClass;

public class ElementHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<?> wrappingType;
    private WebDriver driver;

    /**
     * Generates a handler to retrieve the WebElement from a locator for a given WebElement interface descendant.
     *
     * @param interfaceType Interface wrapping this class. It contains a reference the the implementation.
     * @param locator       Element locator that finds the element on a page.
     * @param <T>           type of the interface
     */
    public <T> ElementHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if (!WrapperWebElement.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to Element.");
        }

        this.wrappingType = getWrapperClass(interfaceType);
    }

    public <T> ElementHandler(Class<T> interfaceType, ElementLocator locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
        if (!WrapperWebElement.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to Element.");
        }

        this.wrappingType = getWrapperClass(interfaceType);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {

        By by;
        Field elementField;
        try {
            elementField = locator.getClass().getDeclaredField("by");
            elementField.setAccessible(true);
            by = (By) elementField.get(locator);
        } catch (Exception e) {
            throw new Exception("Failed to obtain element locator - " + locator.toString());
        }

        final WebElement element;
        try {
            element = locator.findElement();
        } catch (NoSuchElementException e) {
            if ("toString".equals(method.getName())) {
                return "Proxy element for: " + locator.toString();
            }
            throw new Exception("Element not found - " + locator.toString());
        }

        if ("getWrappedElement".equals(method.getName())) {
            return element;
        }
        Constructor<?> cons = wrappingType.getConstructor(WebDriver.class, WebElement.class, By.class, ElementLocator.class);

        try {
            Object thing = cons.newInstance(driver, element, by, locator);
            return method.invoke(wrappingType.cast(thing), objects);
        } catch (InvocationTargetException e) {
            // Unwrap the underlying exception
            throw e.getCause();
        }
    }
}