package runner.ui;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.junit.JUnit4TestRunner;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/ui"},
        glue = {"ContextConfig/UI", "Steps"},
        publish = true,
        plugin = {"pretty", "junit:target/junit-reports/", "json:target/cucumber/cucumber-reports.json"}
)
public class UiRunner extends AbstractTestNGCucumberTests {
}

