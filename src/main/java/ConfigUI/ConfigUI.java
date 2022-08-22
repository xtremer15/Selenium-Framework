package ConfigUI;

import HTMLElements.Button;
import Pages.CartPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Configuration
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


    @Bean
    @Lazy
    @Scope("cucumber-glue")
    Actions actions() {
        return new Actions(webDriver());
    }


    @Bean
    @Lazy
    @Scope("cucumber-glue")
    Button button() {
        return new Button();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    CartPage cartPage() {
        return new CartPage();
    }
}
