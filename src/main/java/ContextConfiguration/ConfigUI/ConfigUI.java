package ContextConfiguration.ConfigUI;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;


@Configuration
@ConditionalOnProperty(name = "ui.runner.enabled",havingValue = "true")
public class ConfigUI {

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    JavascriptExecutor javascriptExecutor() {
        return (JavascriptExecutor) webDriver();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    LoginPage loginPage() {
        return new LoginPage();
    }

}
