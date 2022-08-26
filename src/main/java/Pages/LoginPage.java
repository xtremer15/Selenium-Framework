package Pages;



import ConfigUI.BasePage;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {
    @Autowired
    WebDriver driver;

    @Autowired
    JavascriptExecutor javascriptExecutor;

    @FindBy(id = "search_query_top")
    WebElement searchTxt;

    @FindBy(css = "#homefeatured li")
    private List<WebElement> productsList;

    private By contact = By.cssSelector("#contact-link > a");
    private By searchInput = By.id("search_query_top");

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

    public void searchSmtgh() throws InterruptedException {
        searchTxt.sendKeys("salutari");
    }

    @SneakyThrows
    public void openNewTab() {
        System.out.println("METHOD EXECUTED");

        ((JavascriptExecutor) driver).executeScript("window.open(\"http://automationpractice.com/index.php\",\"_blank\");");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        searchTxt.sendKeys("salut");


    }

    public void showListSize() {
        productsList.forEach(System.out::println);
    }
}
