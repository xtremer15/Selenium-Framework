package Steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginStep {
    @Autowired
    LogPage logPage;


    @Given("i will open the browser")
    public void i_will_open_the_browser() throws InterruptedException {
        logPage.searchText("draci sa il ia ca nu merge");
    }
}
