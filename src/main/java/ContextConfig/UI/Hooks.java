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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    @Autowired()
    WebDriver webDriver;

    @Before
    public void setup() {
        this.chromeCapabilities();
        this.chromeOptions();
        webDriver.navigate().to("https://angular-login-module.vercel.app/login");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void chromeCapabilities() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.getCapabilityNames();
        capabilities.setAcceptInsecureCerts(true);

    }

    public void chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setAcceptInsecureCerts(false);
        chromeOptions.getBrowserName();
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
    }

    @After
    public void Quit() {
//        webDriver.close();
//        webDriver.quit();
    }
}
