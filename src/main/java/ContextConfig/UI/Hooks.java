package ContextConfig.UI;


import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired()
    WebDriver webDriver;

    @Before
    public void setup() {
        webDriver.navigate().to("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
    }
}
