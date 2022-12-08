package ContextConfig.UI;

import Interfaces.Page;
import Utils.factory.ExtendedPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public abstract class BasePage implements Page {
    public WebDriverWait webDriverWait;
    @Autowired
    private WebDriver driver;

    @PostConstruct
    private void init() throws Exception {
        ExtendedPageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public WebDriver getDriver() {
        if (this.driver != null) {
            return this.driver;
        } else {
            return null;
        }
    }
}
