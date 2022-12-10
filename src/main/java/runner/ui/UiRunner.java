package runner.ui;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/ui"},
        glue = {"ContextConfig/UI", "Steps"},
        publish = false,
        plugin = {"pretty", "json:target/cucumber/cucumber-reports"}
)
public class UiRunner extends AbstractTestNGCucumberTests {
}
