package Utils.ExtendedWebElementImpl;

import Utils.annotation.ImplementedBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@ImplementedBy(ExtendedWebElementImpl.class)
public interface ExtendedWebElement extends WebElement, WrapsElement, Locatable {


    /**
     * Gets/Creates the {@link WebDriver} instance
     *
     * @return {@link WebDriver} object
     */
    WebDriver getDriver();

    /**
     * Gets/Creates the {@link WebElement} instance
     *
     * @return {@link WebElement} object
     */
    WebElement getElement();

    FluentWait fluentWait();

    FluentWait fluentWait(int timeout, int pollingtime);

    /**
     * Gets/Creates the {@link WebDriver} instance
     *
     * @return {@link WebDriver} object
     */
    WebDriver getWrappedDriver();

    /**
     * Method to check the {@link WebElement} is ready to use
     *
     * @return true if {@link WebElement} is available, if not false
     */
    boolean elementWired();

    /**
     * Method to check the visibility of {@link WebElement}
     *
     * @return true if {@link WebElement} is visible, if not false
     */
    boolean isVisible();

    /**
     * Method to wait until the {@link ExtendedWebElement} is visible within default time
     *
     * @return {@link WebElement} object
     */
    ExtendedWebElement waitUntilVisible();

    /**
     * Method to wait until the {@link ExtendedWebElement} is visible within given time
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} visibility
     * @return {@link ExtendedWebElement} object
     */
    ExtendedWebElement waitUntilVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link ExtendedWebElement} is visible within default time with {@link By} locator
     *
     * @return {@link WebElement} object
     */
    ExtendedWebElement waitByUntilVisible();

    /**
     * Method to wait until the {@link ExtendedWebElement} is visible within given time with {@link By} locator
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} visibility
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitByUntilVisible(long)
     */
    ExtendedWebElement waitByUntilVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link ExtendedWebElement} is present within default time
     *
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilPresent()
     */
    ExtendedWebElement waitUntilPresent();

    /**
     * Method to wait until the {@link ExtendedWebElement} is present within given time
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} to present
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilPresent(long)
     */
    ExtendedWebElement waitUntilPresent(long timeOutInSeconds);

    /**
     * Method to wait for invisibility of the {@link ExtendedWebElement} within default time
     *
     * @return true if {@link ExtendedWebElement} is not visible, if not false
     * @see ExtendedWebElementImpl#waitUntilNotVisible()
     */
    boolean waitUntilNotVisible();

    /**
     * Method to wait for invisibility of the {@link ExtendedWebElement} within given time
     *
     * @param timeOutInSeconds time to wait for invisibility of the {@link ExtendedWebElement}
     * @return true if {@link ExtendedWebElement} is not visible, if not false
     * @see ExtendedWebElementImpl#waitUntilNotVisible(long)
     */
    boolean waitUntilNotVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link ExtendedWebElement} is enabled within default time
     *
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilEnabled()
     */
    ExtendedWebElement waitUntilEnabled();

    /**
     * Method to wait until the {@link ExtendedWebElement} is enabled within given time
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} to be enabled
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilEnabled(long)
     */
    ExtendedWebElement waitUntilEnabled(long timeOutInSeconds);

    /**
     * Method to wait until the {@link ExtendedWebElement} is clickable within default time
     *
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilClickable()
     */
    ExtendedWebElement waitUntilClickable();

    /**
     * Method to wait until the {@link ExtendedWebElement} is clickable within give time
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} to be clickable
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilClickable(long)
     */
    ExtendedWebElement waitUntilClickable(long timeOutInSeconds);

    /**
     * Method to wait until the {@link ExtendedWebElement} is disabled within default time
     *
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilDisabled()
     */
    ExtendedWebElement waitUntilDisabled();

    /**
     * Method to wait until the {@link ExtendedWebElement} is disabled within give time
     *
     * @param timeOutInSeconds time to wait for {@link ExtendedWebElement} to be disabled
     * @return {@link ExtendedWebElement} object
     * @see ExtendedWebElementImpl#waitUntilDisabled(long)
     */
    ExtendedWebElement waitUntilDisabled(long timeOutInSeconds);

    /**
     * Method to return text of value attribute for the {@link ExtendedWebElement}
     *
     * @return text of value attribute
     * @see ExtendedWebElementImpl#getValue()
     */
    String getValue();

    /**
     * Method to return inner text of the {@link ExtendedWebElement}
     *
     * @return inner text
     * @see ExtendedWebElementImpl#getText()
     */
    String getText();

    /**
     * Method to return text of textContent attribute for the {@link ExtendedWebElement}
     *
     * @return text of textContent attribute
     * @see ExtendedWebElementImpl#getTextContent()
     */
    String getTextContent();

    /**
     * Method to click the {@link ExtendedWebElement}
     *
     * @see ExtendedWebElementImpl#click()
     */
    void click();

    /**
     * Method to click the {@link ExtendedWebElement} using javascript with {@link JavascriptExecutor}
     *
     * @see ExtendedWebElementImpl#jsClick()
     */
    void jsClick();

    /**
     * Method to clear/delete within the {@link ExtendedWebElement}
     *
     * @see ExtendedWebElementImpl#clear()
     */
    void clear();

    /**
     * Method to set text to the {@link ExtendedWebElement}
     *
     * @param keysToSend text to set
     * @see ExtendedWebElementImpl#sendKeys(CharSequence...)
     */
    void sendKeys(CharSequence... keysToSend);

    /**
     * Method to set text to the {@link ExtendedWebElement}
     *
     * @param keysToSend text to set
     * @see ExtendedWebElementImpl#sendKeybyKey(String)
     */
    void sendKeybyKey(String keysToSend);

    /**
     * Method to set text to the {@link ExtendedWebElement}
     *
     * @param keysToSend text to set
     * @param timegap    time gap between each key stroke in millis
     * @see ExtendedWebElementImpl#sendKeybyKey(long, String)
     */
    void sendKeybyKey(long timegap, String keysToSend);

    /**
     * Method to submit the form {@link ExtendedWebElement}
     *
     * @see ExtendedWebElementImpl#submit()
     */
    void submit();

    /**
     * Method to return tag name of the {@link ExtendedWebElement}
     *
     * @return tag name
     * @see ExtendedWebElementImpl#getTagName()
     */
    String getTagName();

    /**
     * Method to return text value of given attribute of the {@link ExtendedWebElement}
     *
     * @return text value of given attribute
     * @see ExtendedWebElementImpl#getAttribute(String)
     */
    String getAttribute(String propertyName);

    /**
     * Method to check the {@link ExtendedWebElement} is selected or not
     *
     * @return true if {@link ExtendedWebElement} is selected, if not false
     * @see ExtendedWebElementImpl#isSelected()
     */
    boolean isSelected();

    /**
     * Method to check the {@link ExtendedWebElement} is enabled or not
     *
     * @return true if {@link ExtendedWebElement} is enabled, if not false
     * @see ExtendedWebElementImpl#isEnabled()
     */
    boolean isEnabled();

    /**
     * Method to return the list of elements {@link List<ExtendedWebElement>}
     *
     * @param by locator
     * @return List of WebElements
     * @see ExtendedWebElementImpl#findAllBy(By)
     */
    List<ExtendedWebElement> findAllBy(By by);

    /**
     * Method to return the {@link ExtendedWebElement} with locator
     *
     * @param by locator
     * @return {@link ExtendedWebElement}
     * @see ExtendedWebElementImpl#findBy(By)
     */
    ExtendedWebElement findBy(By by);

    /**
     * Method to check the {@link ExtendedWebElement} is displayed or not
     *
     * @return true if {@link ExtendedWebElement} is displayed, if not false
     * @see ExtendedWebElementImpl#isDisplayed()
     */
    boolean isDisplayed();

    /**
     * Method to get the point({@link Point}) location of the {@link ExtendedWebElement}
     *
     * @return location
     * @see ExtendedWebElementImpl#getLocation()
     */
    Point getLocation();

    /**
     * Method to get the dimension({@link Dimension}) of the {@link ExtendedWebElement}
     *
     * @return dimension
     * @see ExtendedWebElementImpl#getSize()
     */
    Dimension getSize();

    /**
     * Method to get the rectangle({@link Rectangle}) of the {@link ExtendedWebElement}
     *
     * @return rectangle
     * @see ExtendedWebElementImpl#getRect()
     */
    Rectangle getRect();

    /**
     * Method to return CSS property for the {@link ExtendedWebElement}
     *
     * @param propertyName CSS property
     * @return CSS value for the property
     * @see ExtendedWebElementImpl#getTagName()
     */
    String getCssValue(String propertyName);

    /**
     * Method to highlight the {@link ExtendedWebElement}
     *
     * @see ExtendedWebElementImpl#highlight()
     */
    void highlight();

    /**
     * Method to scroll to the the {@link ExtendedWebElement}
     *
     * @see ExtendedWebElementImpl#scrollIntoView()
     */
    void scrollIntoView();

    /**
     * Method to refresh the {@link ExtendedWebElement}
     * This method is for iOS only
     *
     * @see ExtendedWebElementImpl#refresh()
     */
    void refresh();

    /**
     * Method to take the screenshot of the page
     *
     * @param target screenshot format {@link OutputType}
     * @return screenshot of provided format
     * @see ExtendedWebElementImpl#getScreenshotAs(OutputType)
     */
    <X> X getScreenshotAs(OutputType<X> target);

    /**
     * Webdriver wait method {@link WebDriverWait}
     *
     * @return webdriver wait object
     * @see ExtendedWebElementImpl#waitForCondition()
     */
    WebDriverWait waitForCondition();

    /**
     * Method to check the {@link ExtendedWebElement} is present or not
     *
     * @return true if {@link ExtendedWebElement} is present, if not false
     * @see ExtendedWebElementImpl#isPresent()
     */
    boolean isPresent();

}
