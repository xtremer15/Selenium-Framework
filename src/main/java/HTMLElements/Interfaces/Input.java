package HTMLElements.Interfaces;

import HTMLElements.InputImpl;
import Utils.WrapperWebElementImpl.WrapperWebElement;
import Utils.annotation.ImplementedBy;

@ImplementedBy(InputImpl.class)
public interface Input extends WrapperWebElement {

    /**
     * Wraps selenium {@link org.openqa.selenium.WebElement}
     *
     */
    void simulateUserTyping(String text);
}
