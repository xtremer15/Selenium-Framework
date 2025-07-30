package Pages;


import ContextConfig.UI.BasePage;
import HTMLElements.Interfaces.Input;
import Library.KeyBoard;
import Services.Service;
import Utils.Interfaces.Button;
import Utils.Sleeper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class LoginPage extends BasePage {

    @Autowired
    WebDriver driver;

    @FindBy(xpath = "//label[text()=\"User\"]/preceding-sibling::input")
    Input userName;

    @FindBy(xpath = "//label[text()=\"Password\"]/preceding-sibling::input")
    Input password;
    @FindBy(css = "button[type=\"submit\"]")
    Button loginBtn;

    private By contact = By.cssSelector("#contact-link > a");
    private By searchInpt = By.id("search_query_top");


    public By getContact() {
        return contact;
    }

    public void clickLogin() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }


    public void typeText(String textToType) {
        userName.simulateUserTyping(textToType);
        Sleeper.sleep(200000L);
    }
}
