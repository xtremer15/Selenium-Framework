package HTMLElements;

import org.openqa.selenium.By;

public class Button extends Element{
    @Override
    public void click(By elem) {
        driver.findElement(elem).click();
    }
}
