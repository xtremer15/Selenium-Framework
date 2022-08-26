package HTMLElements.Interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface HTMLElement {
    void click(By elem);

    String getAttribute(By element,String attribute);

    void focusElement(By element);

    String getCssColor(By element);

    List<WebElement> getParentNodeByXpath(String element);

    List<WebElement> getChildNodeByXpath(String element);
}
