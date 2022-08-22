package Pages;

import HTMLElements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartPage {
    @Autowired
    Button button;

    private By cartBtn = By.cssSelector(".shopping_cart>a");
    private String xpathSelectorCartBtn = "//*[@class=\"shopping_cart\"]/a";
    private By header = By.cssSelector("#header_logo+div");

    public void clickCartButton() {
         String valriabila = "ceva";
         int number = 2;
         char a = 'a';
        System.out.println("BTN CLICKED!!!");
        System.out.println("atributul  este =>" + button.getAttribute(header, "id"));
        System.out.println("color este =>" + button.getCssColor(cartBtn));
        List<WebElement> parentNodes = button.getParentNodeByXpath(xpathSelectorCartBtn);
        List<WebElement> childNodes = button.getChildNodeByXpath(xpathSelectorCartBtn);
        parentNodes.forEach(System.out::println);
        childNodes.forEach(System.out::println);
        button.click(cartBtn);
    }
}
