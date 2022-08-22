package HTMLElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class Element implements HTMLElement {
    @Autowired
    WebDriver driver;

    @Autowired
    Actions actions;

    @Override
    public String getAttribute(By element, String attribute) {
        return driver.findElement(element).getCssValue(attribute);
    }

    @Override
    public void focusElement(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public String getCssColor(By element) {
        return driver.findElement(element).getCssValue("color");
    }

    @Override
    public List<WebElement> getParentNodeByXpath(String ele) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].parentNode;", element);
        return driver.findElements(By.xpath(ele+"/parent::*"));
    }

    @Override
    public List<WebElement> getChildNodeByXpath(String ele) {
       return driver.findElements(By.xpath(ele+"/child::*"));
    }
}
