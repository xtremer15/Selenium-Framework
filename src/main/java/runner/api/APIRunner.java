package runner.api;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/api"},
        glue = {"ContextConfiguration","API","ConfigAPI.java", "Steps"},
        stepNotifications = false,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class APIRunner {
}
