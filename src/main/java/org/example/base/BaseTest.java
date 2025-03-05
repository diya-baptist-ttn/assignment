package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected String username = "Admin";
    protected String password = "admin123";

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
