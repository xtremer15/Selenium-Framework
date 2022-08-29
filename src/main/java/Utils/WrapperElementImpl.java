package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class WrapperElementImpl implements WrapperElement {
    protected WebElement element;

    @Autowired
    protected WebDriver driver;
    protected ElementLocator locator;
    protected By by;

    public WrapperElementImpl(WebDriver driver, WebElement element,ElementLocator locator, By by) {
        this.element = element;
        this.driver = driver;
        this.locator = locator;
        this.by = by;
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public WebElement getElement() {
        return this.element;
    }

    @Override
    public void simulateUserTyping(String textToType) {
        System.out.println("Am executat din WrapperElementIMPL");
        Arrays.stream(textToType.split("")).forEach((str) ->
        {
            this.getElement().sendKeys(textToType);
            try {
                Thread.sleep(168L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    @Override
    public void click() {
        this.getElement().click();
    }

    @Override
    public void submit() {
        this.getElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }
}
