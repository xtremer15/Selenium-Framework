package Steps;

import Pages.CartPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CartPageStep {
    @Autowired
    CartPage cartPage;

    @Then("user will click cart button")
    public void userWillClickCartButton() {
        cartPage.clickCartButton();
    }
}
