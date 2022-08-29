package Utils.ExtendedWebElementImpl;

import Utils.Sleeper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtendedWebElementImpl implements ExtendedWebElement {

    protected WebElement element;
    protected By by;
    protected WebDriver driver;
    protected ElementLocator locator;


    /**
     * Creates a Element for a given WebElement.
     *
     * @param driver  WebDriver
     * @param element WebElement to wrap up
     * @param by      by locator to wrap WebElement
     * @param locator element locator
     */
    public ExtendedWebElementImpl(final WebDriver driver, final WebElement element, final By by, final ElementLocator locator) {
        this.driver = driver;
        this.element = element;
        this.by = by;
        this.locator = locator;
    }

    /**
     * @see WebElement#click()
     */
    @Override
    public void click() {
        waitUntilEnabled();
        getElement().click();
    }

    @Override
    public void jsClick() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", getElement());
    }

    /**
     * @see WebElement#submit()
     */
    @Override
    public void submit() {
        waitUntilPresent();
        getElement().submit();
    }

    /**
     * @see WebElement#sendKeys(CharSequence...)
     */
    @Override
    public void sendKeys(CharSequence... textToSet) {
        waitUntilPresent();
        getElement().sendKeys(textToSet);
        String keys = "";
        for (CharSequence key : textToSet) {
            if (key instanceof Keys) {
                if (keys.isEmpty()) {
                    keys = "Key." + ((Keys) key).name();
                } else {
                    keys += " + Key." + ((Keys) key).name();
                }
            } else {
                if (keys.isEmpty()) {
                    keys = key.toString();
                } else {
                    keys += key.toString();
                }
            }
        }
        log("Sending text/keys { " + keys + " } to the textbox " + elementLocator());
    }

    /**
     * @param textToSet text to set
     * @see ExtendedWebElement#sendKeybyKey(String)
     */
    @Override
    public void sendKeybyKey(String textToSet) {
        waitUntilPresent();
        Arrays.stream(textToSet.split("")).forEach(str -> {
            getElement().sendKeys(str);
            Sleeper.sleep(200);
        });
    }

    /**
     * @param timegap   time gap between each key stroke in millis
     * @param textToSet test to set
     * @see ExtendedWebElement#sendKeybyKey(long, String)
     */
    @Override
    public void sendKeybyKey(long timegap, String textToSet) {
        waitUntilPresent();
        Arrays.stream(textToSet.split("")).forEach(str -> {
            getElement().sendKeys(str);
            Sleeper.sleep(timegap);
        });
    }

    /**
     * @see WebElement#clear()
     */
    @Override
    public void clear() {
        waitUntilPresent();
        getElement().clear();
    }

    /**
     * @see WebElement#getTagName()
     */
    @Override
    public String getTagName() {
        waitUntilPresent();
        String tagName = getElement().getTagName();
        return tagName;
    }

    /**
     * @see WebElement#getAttribute(String)
     */
    @Override
    public String getAttribute(String attr) {
        waitUntilPresent();
        String value = getElement().getAttribute(attr);
        return value;
    }

    /**
     * @see WebElement#isSelected()
     */
    @Override
    public boolean isSelected() {
        waitUntilPresent();
        boolean selected = getElement().isSelected();
        return selected;
    }

    /**
     * @see WebElement#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        waitUntilPresent();
        boolean enabled = getElement().isEnabled();
        return enabled;
    }

    /**
     * @see WebElement#getText()
     */
    @Override
    public String getText() {
        waitUntilPresent();
        String text = getElement().getText();
        if (text.equals("")) {
            Sleeper.sleep(500);
            text = getElement().getText();
        }
        return text;
    }

    /**
     * @see WebElement#findElements(By)
     */
    @Override
    public List<WebElement> findElements(By by) {
        log("Finding the element list with DefaultElementLocator { " + by.toString() + " }");
        return getElement().findElements(by);
    }

    /**
     * @see WebElement#findElement(By)
     */
    @Override
    public WebElement findElement(By by) {
        log("Finding the element with DefaultElementLocator { " + by.toString() + " }");
        return getElement().findElement(by);
    }

    @Override
    public String getTextContent() {
        waitUntilPresent();
        String text = getElement().getAttribute("textContent");
        log("Element text content is { " + text + " } " + elementLocator());
        return text;
    }

    @Override
    public List<ExtendedWebElement> findAllBy(By by) {
        waitUntilPresent();
        return findElements(by).stream().map(element -> new ExtendedWebElementImpl(driver, element, by, locator)).collect(Collectors.toList());
    }

    @Override
    public ExtendedWebElement findBy(By by) {
        waitUntilPresent();
        return new ExtendedWebElementImpl(driver, findElement(by), by, locator);
    }

    /**
     * @see WebElement#isDisplayed()
     */
    @Override
    public boolean isDisplayed() {
        waitUntilPresent();
        boolean isdisplayed = getElement().isDisplayed();
        log("Element is displayed { " + isdisplayed + " } " + elementLocator());
        return isdisplayed;
    }

    /**
     * @see WebElement#getLocation()
     */
    @Override
    public Point getLocation() {
        waitUntilPresent();
        Point point = getElement().getLocation();
        log("Element point X,Y { " + point.toString() + " } " + elementLocator());
        return point;
    }

    /**
     * @see WebElement#getSize()
     */
    @Override
    public Dimension getSize() {
        waitUntilPresent();
        Dimension dimension = getElement().getSize();
        log("Element width,height { " + dimension.toString() + " } " + elementLocator());
        return dimension;
    }

    /**
     * @see WebElement#getRect()
     */
    @Override
    public Rectangle getRect() {
        waitUntilPresent();
        Rectangle rect = getElement().getRect();
        log("Element x,y { " + rect.getPoint().toString() + " } and width,height { " + rect.getDimension().toString() + " } " + elementLocator());
        return rect;
    }

    /**
     * @see WebElement#getCssValue(String)
     */
    @Override
    public String getCssValue(String css) {
        waitUntilPresent();
        String cssValue = getElement().getCssValue(css);
        log("Element CSS value is  { " + cssValue + " } " + elementLocator());
        return cssValue;
    }

    @Override
    public void highlight() {
    }

    @Override
    public void scrollIntoView() {
        waitUntilPresent();
        log("Scrolling Element into view " + elementLocator());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    @Override
    public void refresh() {
        ((JavascriptExecutor) getDriver()).executeScript("const tracker = arguments[0]._valueTracker;\n" +
                "            if (tracker) {\n" +
                "                tracker.setValue('');\n" +
                "            }\n" +
                "            arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", getElement());
    }

    /**
     * @see WebElement#getScreenshotAs(OutputType)
     */
    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        log("Take Screenshot");
        return ((TakesScreenshot) getDriver()).getScreenshotAs(outputType);
    }

    @Override
    public WebDriverWait waitForCondition() {
        return new WebDriverWait(getDriver(), 10);
    }

    @Override
    public FluentWait fluentWait() {
        return new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
    }

    @Override
    public FluentWait fluentWait(int timeout, int pollingtime) {
        return new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingtime))
                .ignoring(NoSuchElementException.class);
    }

    public WebDriverWait waitForCondition(long timeOutInSeconds) {
        return new WebDriverWait(getDriver(), timeOutInSeconds);
    }


    @Override
    public WebElement getWrappedElement() {
        return getElement();
    }

    @Override
    public WebDriver getWrappedDriver() {
        return getDriver();
    }

    @Override
    public Coordinates getCoordinates() {
        log("Locating Element Coordinates " + elementLocator());
        return ((Locatable) getElement()).getCoordinates();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebElement getElement() {
        return element;
    }

    @Override
    public boolean elementWired() {
        return getElement() != null;
    }

    @Override
    public boolean isVisible() {
        log("Element visibility");
        try {
            WebElement element = getElement();
            return (element != null) && (element.isDisplayed());
        } catch (ElementNotVisibleException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    @Override
    public ExtendedWebElement waitUntilVisible() {
     return this;
    }

    @Override
    public ExtendedWebElement waitUntilVisible(long timeOutInSeconds) {
        return this;
    }

    @Override
    public ExtendedWebElement waitByUntilVisible() {
        return this;
    }

    @Override
    public ExtendedWebElement waitByUntilVisible(long timeOutInSeconds) {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilPresent() {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilPresent(long timeOutInSeconds) {
        return this;
    }

    @Override
    public boolean waitUntilNotVisible() {
        return true;
    }

    @Override
    public boolean waitUntilNotVisible(long timeOutInSeconds) {
    return false;
    }

    @Override
    public ExtendedWebElement waitUntilEnabled() {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilEnabled(long timeOutInSeconds) {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilClickable() {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilClickable(long timeOutInSeconds) {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilDisabled() {
        return this;
    }

    @Override
    public ExtendedWebElement waitUntilDisabled(long timeOutInSeconds) {
        return this;
    }


    @Override
    public String getValue() {
        waitUntilPresent();
        String value = getElement().getAttribute("value");
        log("Element value attribute is { " + value + " } " + elementLocator());
        return value;
    }

    @Override
    public boolean isPresent() {
        try {
            WebElement element = getElement();
            if (element == null) {
                return false;
            }
            element.isDisplayed();
            return true;
        } catch (ElementNotVisibleException e) {
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    /**
     * Method to log the locator
     *
     * @return locator
     */
    private String elementLocator() {
        return "with { " + locator.toString() + " }";
    }

    private void log(String message) {
//        if (LOG) {
//            Logger.info(message);
//        }
    }
}