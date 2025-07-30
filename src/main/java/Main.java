import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime=0;
        // Set up WebDriver (Make sure to have chromedriver in your PATH)
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a test website
            driver.get("https://the-internet.herokuapp.com/");

            // Set implicit wait (11 seconds)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Start timing the execution
             startTime = System.currentTimeMillis();

            // Apply explicit wait (5 seconds) for a non-existent element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistentElement")));

            // This line should never be reached since the element doesn't exist
            System.out.println("Element found: " + element.getText());

        } catch (Exception e) {
            // Capture the total time taken
            long endTime = System.currentTimeMillis();
            long totalWaitTime = (endTime - startTime) / 1000; // Convert to seconds
            System.out.println("Total wait time: " + totalWaitTime + " seconds");
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}