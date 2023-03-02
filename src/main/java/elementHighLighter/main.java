package elementHighLighter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) throws URISyntaxException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriver.navigate().to("https://eviltester.github.io/synchole/collapseable.html");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        Actions actions = new Actions(webDriver);
////        WebElement body = webDriver.findElement(By.cssSelector("#collapsable .synchole"));
////        WebElement syncholeLink = webDriver.findElement(By.id("aboutlink"));

//        System.out.println("adsadadad");
//        actions.moveToElement(body);
//        System.out.println("adsadad");
//        syncholeLink.click();
//        URI currentURI = new URI(webDriver.getCurrentUrl());
//        System.out.println("URI =>" + currentURI);
//        String about = currentURI.getPath();

        WebElement shortLiverdEvents = webDriver.findElement(By.xpath("//*[contains(text(),'Shortlived Events')]"));
        shortLiverdEvents.click();
        List<WebElement> tasks = webDriver.findElements(By.cssSelector("#progressrendering p progress"));


        for (int i = 0; i < tasks.size(); i++) {
            boolean completed = webDriverWait.until(ExpectedConditions.attributeToBe(tasks.get(i), tasks.get(i).getAttribute("value"), "100"));
            if (completed) {
                System.out.println("complet");
                webDriver.quit();
            }
        }

    }


}
