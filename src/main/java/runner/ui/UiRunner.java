package runner.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/ui"},
        glue = {"ConfigUI","Steps"},
        stepNotifications = false,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class UiRunner {
}
