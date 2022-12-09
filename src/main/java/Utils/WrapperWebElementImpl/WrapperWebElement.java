package Utils.WrapperWebElementImpl;

import Utils.annotation.ImplementedBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@ImplementedBy(WrapperWebElementImpl.class)
public interface WrapperWebElement extends WebElement, WrapsElement, Locatable {


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
     * Method to wait until the {@link WrapperWebElement} is visible within default time
     *
     * @return {@link WebElement} object
     */
    WrapperWebElement waitUntilVisible();

    /**
     * Method to wait until the {@link WrapperWebElement} is visible within given time
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} visibility
     * @return {@link WrapperWebElement} object
     */
    WrapperWebElement waitUntilVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link WrapperWebElement} is visible within default time with {@link By} locator
     *
     * @return {@link WebElement} object
     */
    WrapperWebElement waitByUntilVisible();

    /**
     * Method to wait until the {@link WrapperWebElement} is visible within given time with {@link By} locator
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} visibility
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitByUntilVisible(long)
     */
    WrapperWebElement waitByUntilVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link WrapperWebElement} is present within default time
     *
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilPresent()
     */
    WrapperWebElement waitUntilPresent();

    /**
     * Method to wait until the {@link WrapperWebElement} is present within given time
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} to present
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilPresent(long)
     */
    WrapperWebElement waitUntilPresent(long timeOutInSeconds);

    /**
     * Method to wait for invisibility of the {@link WrapperWebElement} within default time
     *
     * @return true if {@link WrapperWebElement} is not visible, if not false
     * @see WrapperWebElementImpl#waitUntilNotVisible()
     */
    boolean waitUntilNotVisible();

    /**
     * Method to wait for invisibility of the {@link WrapperWebElement} within given time
     *
     * @param timeOutInSeconds time to wait for invisibility of the {@link WrapperWebElement}
     * @return true if {@link WrapperWebElement} is not visible, if not false
     * @see WrapperWebElementImpl#waitUntilNotVisible(long)
     */
    boolean waitUntilNotVisible(long timeOutInSeconds);

    /**
     * Method to wait until the {@link WrapperWebElement} is enabled within default time
     *
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilEnabled()
     */
    WrapperWebElement waitUntilEnabled();

    /**
     * Method to wait until the {@link WrapperWebElement} is enabled within given time
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} to be enabled
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilEnabled(long)
     */
    WrapperWebElement waitUntilEnabled(long timeOutInSeconds);

    /**
     * Method to wait until the {@link WrapperWebElement} is clickable within default time
     *
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilClickable()
     */
    WrapperWebElement waitUntilClickable();

    /**
     * Method to wait until the {@link WrapperWebElement} is clickable within give time
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} to be clickable
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilClickable(long)
     */
    WrapperWebElement waitUntilClickable(long timeOutInSeconds);

    /**
     * Method to wait until the {@link WrapperWebElement} is disabled within default time
     *
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilDisabled()
     */
    WrapperWebElement waitUntilDisabled();

    /**
     * Method to wait until the {@link WrapperWebElement} is disabled within give time
     *
     * @param timeOutInSeconds time to wait for {@link WrapperWebElement} to be disabled
     * @return {@link WrapperWebElement} object
     * @see WrapperWebElementImpl#waitUntilDisabled(long)
     */
    WrapperWebElement waitUntilDisabled(long timeOutInSeconds);

    /**
     * Method to return text of value attribute for the {@link WrapperWebElement}
     *
     * @return text of value attribute
     * @see WrapperWebElementImpl#getValue()
     */
    String getValue();

    /**
     * Method to return inner text of the {@link WrapperWebElement}
     *
     * @return inner text
     * @see WrapperWebElementImpl#getText()
     */
    String getText();

    /**
     * Method to return text of textContent attribute for the {@link WrapperWebElement}
     *
     * @return text of textContent attribute
     * @see WrapperWebElementImpl#getTextContent()
     */
    String getTextContent();

    /**
     * Method to click the {@link WrapperWebElement}
     *
     * @see WrapperWebElementImpl#click()
     */
    void click();

    /**
     * Method to click the {@link WrapperWebElement} using javascript with {@link JavascriptExecutor}
     *
     * @see WrapperWebElementImpl#jsClick()
     */
    void jsClick();

    /**
     * Method to clear/delete within the {@link WrapperWebElement}
     *
     * @see WrapperWebElementImpl#clear()
     */
    void clear();

    /**
     * Method to set text to the {@link WrapperWebElement}
     *
     * @param keysToSend text to set
     * @see WrapperWebElementImpl#sendKeys(CharSequence...)
     */
    void sendKeys(CharSequence... keysToSend);

    /**
     * Method to set text to the {@link WrapperWebElement}
     *
     * @param keysToSend text to set
     * @see WrapperWebElementImpl#sendKeybyKey(String)
     */
    void sendKeybyKey(String keysToSend);

    /**
     * Method to set text to the {@link WrapperWebElement}
     *
     * @param keysToSend text to set
     * @param timegap    time gap between each key stroke in millis
     * @see WrapperWebElementImpl#sendKeybyKey(long, String)
     */
    void sendKeybyKey(long timegap, String keysToSend);

    /**
     * Method to submit the form {@link WrapperWebElement}
     *
     * @see WrapperWebElementImpl#submit()
     */
    void submit();

    /**
     * Method to return tag name of the {@link WrapperWebElement}
     *
     * @return tag name
     * @see WrapperWebElementImpl#getTagName()
     */
    String getTagName();

    /**
     * Method to return text value of given attribute of the {@link WrapperWebElement}
     *
     * @return text value of given attribute
     * @see WrapperWebElementImpl#getAttribute(String)
     */
    String getAttribute(String propertyName);

    /**
     * Method to check the {@link WrapperWebElement} is selected or not
     *
     * @return true if {@link WrapperWebElement} is selected, if not false
     * @see WrapperWebElementImpl#isSelected()
     */
    boolean isSelected();

    /**
     * Method to check the {@link WrapperWebElement} is enabled or not
     *
     * @return true if {@link WrapperWebElement} is enabled, if not false
     * @see WrapperWebElementImpl#isEnabled()
     */
    boolean isEnabled();

    /**
     * Method to return the list of elements {@link List< WrapperWebElement >}
     *
     * @param by locator
     * @return List of WebElements
     * @see WrapperWebElementImpl#findAllBy(By)
     */
    List<WrapperWebElement> findAllBy(By by);

    /**
     * Method to return the {@link WrapperWebElement} with locator
     *
     * @param by locator
     * @return {@link WrapperWebElement}
     * @see WrapperWebElementImpl#findBy(By)
     */
    WrapperWebElement findBy(By by);

    /**
     * Method to check the {@link WrapperWebElement} is displayed or not
     *
     * @return true if {@link WrapperWebElement} is displayed, if not false
     * @see WrapperWebElementImpl#isDisplayed()
     */
    boolean isDisplayed();

    /**
     * Method to get the point({@link Point}) location of the {@link WrapperWebElement}
     *
     * @return location
     * @see WrapperWebElementImpl#getLocation()
     */
    Point getLocation();

    /**
     * Method to get the dimension({@link Dimension}) of the {@link WrapperWebElement}
     *
     * @return dimension
     * @see WrapperWebElementImpl#getSize()
     */
    Dimension getSize();

    /**
     * Method to get the rectangle({@link Rectangle}) of the {@link WrapperWebElement}
     *
     * @return rectangle
     * @see WrapperWebElementImpl#getRect()
     */
    Rectangle getRect();

    /**
     * Method to return CSS property for the {@link WrapperWebElement}
     *
     * @param propertyName CSS property
     * @return CSS value for the property
     * @see WrapperWebElementImpl#getTagName()
     */
    String getCssValue(String propertyName);

    /**
     * Method to highlight the {@link WrapperWebElement}
     *
     * @see WrapperWebElementImpl#highlight()
     */
    void highlight();

    /**
     * Method to scroll to the the {@link WrapperWebElement}
     *
     * @see WrapperWebElementImpl#scrollIntoView()
     */
    void scrollIntoView();

    /**
     * Method to refresh the {@link WrapperWebElement}
     * This method is for iOS only
     *
     * @see WrapperWebElementImpl#refresh()
     */
    void refresh();

    /**
     * Method to take the screenshot of the page
     *
     * @param target screenshot format {@link OutputType}
     * @return screenshot of provided format
     * @see WrapperWebElementImpl#getScreenshotAs(OutputType)
     */
    <X> X getScreenshotAs(OutputType<X> target);

    /**
     * Webdriver wait method {@link WebDriverWait}
     *
     * @return webdriver wait object
     * @see WrapperWebElementImpl#waitForCondition()
     */
    WebDriverWait waitForCondition();

    /**
     * Method to check the {@link WrapperWebElement} is present or not
     *
     * @return true if {@link WrapperWebElement} is present, if not false
     * @see WrapperWebElementImpl#isPresent()
     */
    boolean isPresent();

}
