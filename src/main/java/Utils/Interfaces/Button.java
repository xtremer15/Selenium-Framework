package Utils.Interfaces;

import Utils.WrapperWebElementImpl.WrapperWebElement;
import Utils.Interfaces.Implementation.ButtonEle;
import Utils.annotation.ImplementedBy;

@ImplementedBy(ButtonEle.class)
public interface Button extends WrapperWebElement {

    /**
     * Wraps selenium {@link org.openqa.selenium.WebElement}
     *
     */
    @Override
    void click();

}
