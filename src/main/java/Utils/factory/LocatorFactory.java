package Utils.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class LocatorFactory implements ElementLocatorFactory {
    private final WebDriver driver;

    /**
     * Constructor
     *
     * @param driver {@link WebDriver}
     */
    public LocatorFactory(final WebDriver driver) throws Exception {
        if (driver == null)
            throw new Exception("WebDriver instance is null");
        this.driver = driver;
    }

    @Override
    public ElementLocator createLocator(final Field field) {
        DefaultElementLocator element = new DefaultElementLocator(driver, field);
        return element;

    }
}
