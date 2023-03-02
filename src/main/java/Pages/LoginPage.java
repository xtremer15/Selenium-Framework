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

    Service newSvc = new Service();

    @Autowired
    WebDriver driver;

    @FindBy(id = "search_query_top")
    Input searchInput;

    @FindBy(css = "#contact-link > a")
    Button contactBtn;

    @FindBy(css = "#homefeatured li")
    private List<WebElement> productsList;


    @FindBy(id = "shoppingCartLink")
    private Button shoppingCartBTN;


    private By contact = By.cssSelector("#contact-link > a");
    private By searchInpt = By.id("search_query_top");


    public By getContact() {
        return contact;
    }

    public void clickShoppingCart() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shoppingCartBTN));
        shoppingCartBTN.click();
    }

    public WebElement findEle(By ele) {
        return driver.findElement(ele);
    }


    public void clickContact() {
        contactBtn.click();
    }

    public void showListSize() {
        productsList.forEach(System.out::println);
    }

    public void typeText(String textToType) {
        searchInput.simulateUserTyping(textToType);
        Sleeper.sleep(200000L);
    }
}
