package Utils.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ExtendedPageFactory {
    /**
     * See {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.WebDriver driver, Class)}
     */
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) throws Exception {
        T page = instantiatePage(driver, pageClassToProxy);
        PageFactory.initElements(new ElementDecorator(new LocatorFactory(driver)), page);
        return page;
    }

    /**
     * See {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.support.pagefactory.FieldDecorator, Object)}
     */
    public static void initElements(WebDriver driver, Object page) throws Exception {
        PageFactory.initElements(new ElementDecorator(new LocatorFactory(driver), driver), page);
    }

    /**
     * see {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.support.pagefactory.ElementLocatorFactory, Object)}
     */
    public static void initElements(LocatorFactory factory, Object page) {
        PageFactory.initElements(new ElementDecorator(factory), page);
    }

    /**
     * see {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.support.pagefactory.ElementLocatorFactory, Object)}
     */
    public static void initElements(FieldDecorator decorator, Object page) {
        PageFactory.initElements(decorator, page);
    }

    /**
     * Copy of
     */
    private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException e) {
                try {
                    return pageClassToProxy.newInstance();
                } catch (InstantiationException ie) {
                    throw new Exception("Failed to create instance of: " + pageClassToProxy.getName());
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
