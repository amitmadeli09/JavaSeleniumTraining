package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.nopcommerce.com/");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // initialize here
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null && driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}