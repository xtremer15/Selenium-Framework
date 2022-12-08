package Utils.factory;

import Utils.ExtendedWebElementImpl.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
public class ElementListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<?> wrappingType;
    private WebDriver driver;

    /**
     * Given an interface and a locator, apply a wrapper over a list of elements.
     *
     * @param interfaceType interface type we're trying to wrap around the element.
     * @param locator       locator on the page for the elements.
     * @param <T>           type of the interface.
     */
    public <T> ElementListHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if (!ExtendedWebElement.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to ExtendedWebElement.");
        }
        this.wrappingType = ImplementedByProcessor.getWrapperClass(interfaceType);

    }

    public <T> ElementListHandler(Class<T> interfaceType, ElementLocator locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
        if (!ExtendedWebElement.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to ExtendedWebElement.");
        }
        this.wrappingType = ImplementedByProcessor.getWrapperClass(interfaceType);
    }

    /**
     * Executed on invoke of the requested proxy. Used to gather a list of wrapped WebElements.
     *
     * @param o object to invoke on
     * @param method  method to invoke
     * @param objects parameters for method
     * @return return value from method
     * @throws Throwable when frightened.
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        By by;
        Field elementField;
        try {
            elementField = locator.getClass().getDeclaredField("by");
            elementField.setAccessible(true);
            by = (By) elementField.get(locator);
        } catch (Exception e) {
            throw new Exception("Failed to obtain element locator - " + locator.toString());
        }
        List<Object> wrappedList = new ArrayList<Object>();
        Constructor<?> cons = wrappingType.getConstructor(WebDriver.class, WebElement.class, By.class, ElementLocator.class);
        if (locator.findElements().size() == 0)
            throw new Exception("Element not found  - " + locator.toString());
        for (WebElement element : locator.findElements()) {
            Object thing = cons.newInstance(driver, element, by, locator);
            wrappedList.add(wrappingType.cast(thing));
        }
        try {
            return method.invoke(wrappedList, objects);
        } catch (InvocationTargetException e) {
            // Unwrap the underlying exception
            throw e.getCause();
        }
    }


}