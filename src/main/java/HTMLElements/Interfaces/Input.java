package HTMLElements.Interfaces;

import HTMLElements.InputImpl;
import Utils.ExtendedWebElementImpl.ExtendedWebElement;
import Utils.annotation.ImplementedBy;

@ImplementedBy(InputImpl.class)
public interface Input extends ExtendedWebElement {

    /**
     * Wraps selenium {@link org.openqa.selenium.WebElement}
     *
     */
    void simulateUserTyping(String text);
}
