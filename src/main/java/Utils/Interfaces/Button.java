package Utils.Interfaces;

import Utils.ExtendedWebElementImpl.ExtendedWebElement;
import Utils.Interfaces.Implementation.ButtonEle;
import Utils.annotation.ImplementedBy;

@ImplementedBy(ButtonEle.class)
public interface Button extends ExtendedWebElement {

    /**
     * Wraps selenium {@link org.openqa.selenium.WebElement}
     *
     */
    @Override
    void click();

}
