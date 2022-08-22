package Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public abstract class AbstractExtendedWebElement {
    @Autowired
    WebDriver driver;
    public abstract boolean isVisible(Object annotation, Field field);

    protected WebElement getElement(CheckElementVisibility element){
        return driver.findElement(By.id(String.valueOf(element)));
    }
}
