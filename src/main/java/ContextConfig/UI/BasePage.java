package ContextConfig.UI;

import Interfaces.Page;
import Utils.factory.ExtendedPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public abstract class BasePage implements Page, InitializingBean {
    public WebDriverWait webDriverWait;
    @Autowired
    private WebDriver driver;

//    @EventListener(ApplicationContextInitializer.class)
//    private void setup() throws Exception {
//        ExtendedPageFactory.initElements(driver, this);
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ExtendedPageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebDriver getDriver() {
        if (this.driver != null) {
            return this.driver;
        } else {
            return null;
        }
    }
}
