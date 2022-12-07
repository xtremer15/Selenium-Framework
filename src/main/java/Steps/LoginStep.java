package Steps;

import Library.KeyBoard;
import Pages.LoginPage;
import Utils.Sleeper;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginStep {
    @Autowired
    LoginPage logPage;


    @Given("i will open the browser")
    public void i_will_open_the_browser() throws InterruptedException {
        Sleeper.sleep(2000L);
        logPage.typeText("Hai sa cautam ceva");
    }
}
