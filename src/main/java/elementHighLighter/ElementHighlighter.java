package elementHighLighter;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class ElementHighlighter implements WrapsDriver {

    private final WebDriver decoratedDriver;

    public ElementHighlighter(final WebDriver baseDriver, final String desiredBackgroundColour) {
        this.decoratedDriver = new EventFiringDecorator(new ElementHighlighterListener(desiredBackgroundColour)).decorate(baseDriver);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return decoratedDriver;
    }

    private static class ElementHighlighterListener implements WebDriverListener {
        private final HighlightElement highlighter;

        public ElementHighlighterListener(final String highlightColour) {
            // Driver will be passed later when highlight is used
            this.highlighter = new HighlightElement(null, highlightColour);
        }

        @Override
        public void beforeClick(WebElement element) {
            highlighter.highlight(element);
        }

        public void beforeChangeValueOf(WebElement element, CharSequence[] keysToSend) {
            highlighter.highlight(element);
        }

        @Override
        public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//            highlighter.setDriver(driver); // Set the driver here
            highlighter.highlight(result);
        }
    }
}