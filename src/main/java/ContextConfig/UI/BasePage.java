package ContextConfig.UI;

import API.ControlFactory;
import Interfaces.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BasePage implements Page {
    public WebDriverWait webDriverWait;
    @Autowired
    private WebDriver driver;

    @PostConstruct
    private void init() {
//        PageFactory.initElements(driver, this);
        ControlFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

//    @Override
//    public void simulateUserTyping(String textToType) {
//        Arrays.stream(textToType.split("")).forEach((str) ->
//        {
//            this.pageElement().sendKeys(str);
//            try {
//                Thread.sleep(168L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//    }

//    @Override
//    public void simulateUserTyping(String textToType, By locator) {
//        Arrays.stream(textToType.split("")).forEach((str) ->
//        {
//            pageElement(locator).sendKeys(str);
//            try {
//                Thread.sleep(168L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//    }

//    @Override
//    public WebElement pageElement(By locator) {
//        return driver.findElement(locator);
//    }

}
