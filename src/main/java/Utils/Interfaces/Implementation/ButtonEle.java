package Utils.Interfaces.Implementation;

import Utils.ExtendedWebElementImpl.ExtendedWebElementImpl;
import Utils.Interfaces.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class ButtonEle extends ExtendedWebElementImpl implements Button {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param driver  webdriver
     * @param element Webelement to wrap up
     * @param by      By locator
     * @param locator element locator
     */
    public ButtonEle(WebDriver driver, WebElement element, By by, ElementLocator locator) {
        super(driver, element, by, locator);
    }

    @Override
    public void click() {
        super.scrollIntoView();
        super.click();
    }

}
