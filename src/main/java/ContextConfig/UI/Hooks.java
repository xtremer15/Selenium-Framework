package ContextConfig.UI;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Autowired()
    WebDriver webDriver;

    @Before
    public void setup() {
        webDriver.navigate().to("https://www.advantageonlineshopping.com/#/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void chromeCapabilities() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.getCapabilityNames();
        capabilities.acceptInsecureCerts();
    }

    public void chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.getPlatform();
        chromeOptions.getBrowserName();
        chromeOptions.getVersion();
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
    }

    @After
    public void Quit() {
        webDriver.close();
        webDriver.quit();
    }
}
