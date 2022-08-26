package ContextConfig.UI;

import Annotations.CheckElementVisibility;
import Interfaces.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public abstract class BasePage implements Page {
    public WebDriverWait webDriverWait;
    @Autowired
    private WebDriver driver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Override
    public void simulateUserTyping(String textToType, By locator) {
        Arrays.stream(textToType.split("")).forEach((str) ->
        {
            pageElement(locator).sendKeys(str);
            try {
                Thread.sleep(168L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public WebElement pageElement(@CheckElementVisibility By locator) {
        return driver.findElement(locator);
    }

}
