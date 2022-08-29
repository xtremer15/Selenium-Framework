package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

public interface WrapperElement extends WebElement, WrapsElement, Locatable {
    WebDriver getDriver();

    WebElement getElement();

    void simulateUserTyping(String textToType);
}
