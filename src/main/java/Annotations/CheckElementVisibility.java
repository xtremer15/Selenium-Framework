package Annotations;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER,ElementType.TYPE})
@FactoryExtendedWebElement(CheckElementVisibility.CheckElementBuilder.class)
public @interface CheckElementVisibility {
    String webElement() default "";


    public static class CheckElementBuilder extends AbstractExtendedWebElement {
        @Override
        public boolean isVisible(Object annotation, Field field) {
            CheckElementVisibility annotationType = (CheckElementVisibility) annotation;
            System.out.println("Am facut actiunea din adnotatie si elementul este prezent");
            WebElement element = getElement(annotationType);
            return element.isDisplayed();
        }
    }

}
