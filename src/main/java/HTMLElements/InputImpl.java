package HTMLElements;

import HTMLElements.Interfaces.Input;
import Utils.WrapperWebElementImpl.WrapperWebElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.Arrays;

public class InputImpl extends WrapperWebElementImpl implements Input {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param driver  WebDriver
     * @param element WebElement to wrap up
     * @param by      by locator to wrap WebElement
     * @param locator element locator
     */
    public InputImpl(WebDriver driver, WebElement element, By by, ElementLocator locator) {
        super(driver, element, by, locator);
    }

    @Override
    public void simulateUserTyping(String textToType) {
        Arrays.stream(textToType.split("")).forEach((str) ->
        {
            super.sendKeys(str);
            try {
                Thread.sleep(168L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}
