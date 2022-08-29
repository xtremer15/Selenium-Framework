package ContextConfig.UI;


import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired()
    WebDriver webDriver;

    @Before
    public void setup() {
        webDriver.navigate().to("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
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
}
