package Interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Page {
    public void simulateUserTyping(String textToType, By locator);
    public WebElement pageElement(By locator);
}
