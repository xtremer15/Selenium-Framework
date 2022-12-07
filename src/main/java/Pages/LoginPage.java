package Pages;


import ContextConfig.UI.BasePage;
import HTMLElements.Interfaces.Input;
import Library.KeyBoard;
import Utils.Interfaces.Button;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class LoginPage extends BasePage {
    @Autowired
    WebDriver driver;

    @Autowired
    JavascriptExecutor javascriptExecutor;

    @FindBy(id = "search_query_top")
    Input searchInput;

    @FindBy(css = "#contact-link > a")
    Button contactBtn;

    @FindBy(css = "#homefeatured li")
    private List<WebElement> productsList;

    private By contact = By.cssSelector("#contact-link > a");
    private By searchInpt = By.id("search_query_top");

    //Aceasta este metoda pe care o doresc sa fie executata atunci cand adaug adnotatia mea
    public WebElement checkElementIsVisible(By element) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }


    public void clickElement(By element) {
        //Fie Sa adaug adnotatia deasupra metodei inlantuite mai jos
        //fie sa o adaug la nivel de parametru -> rezultatul mi-as dorii sa fie ca adaugand adnotatia
        //aceasta sa faca actiunea inainte ca sa se execute codul de mai jos

        driver.findElement(element).click();
    }

    public By getContact() {
        return contact;
    }

    public void clickContactUs() {
        System.out.println("Salut am printat ceva din methoda ContactUsClick()");
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        this.webDriverWait.until(driver -> searchTxt.isDisplayed());
//        pageElement(contact).click();
        driver.findElement(contact).click();
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
    }


    @Override
    public void simulateUserTyping(String textToType, By locator) {

    }

    @Override
    public void simulateUserTyping(String textToType) {

    }

    @Override
    public WebElement pageElement(By locator) {
        return null;
    }
}
