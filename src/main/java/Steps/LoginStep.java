package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginStep {
    @Autowired
    LoginPage loginPage;


    @Given("i will open the browser")
    public void i_will_open_the_browser() throws InterruptedException {
        loginPage.clickContactUs();
    }
}
