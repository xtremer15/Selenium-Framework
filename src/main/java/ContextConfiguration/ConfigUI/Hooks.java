package ContextConfiguration.ConfigUI;


import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    WebDriver driver;

    @Before
    public void setup() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }
}
