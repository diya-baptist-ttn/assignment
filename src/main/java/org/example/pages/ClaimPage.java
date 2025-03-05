package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimPage {
    WebDriver driver;

    private By claimMenu = By.xpath("(//a[@class='oxd-main-menu-item'])[10]");
    private By createClaimButton = By.xpath("//a[text()='Submit Claim']");
    private By claimEvent = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error'])[1]");
    private By claimCurrency = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error'])[2]");
    private By submitClaimButton = By.xpath("(//button[@class])[5]");
    private By myClaimsMenu = By.xpath("//a[text()='My Claims']");
    private By firstClaimTitle = By.xpath("//table//tr[1]/td[1]");

    public ClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToClaims() {
        driver.findElement(claimMenu).click();

    }

    public void createClaim() {
        driver.findElement(By.xpath("//a[text()='Submit Claim']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement expenseDropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
        expenseDropdown.click();
        WebElement travelAllowanceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[contains(text(),'Travel Allowance')]")));
        travelAllowanceOption.click();

        // Select "Indian Rupee"
        WebElement currencyDropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
        currencyDropdown.click();
        WebElement indianRupeeOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[contains(text(),'Indian Rupee')]")));
        indianRupeeOption.click();


        driver.findElement(submitClaimButton).click();
    }
    public boolean claimMade(){
        WebElement label = driver.findElement(By.xpath("(//label)[1]"));
        return label.isDisplayed();

    }

    public void goToMyClaims() {
        driver.findElement(By.xpath("//a[text()='My Claims']")).click();
    }

    public boolean isClaimPresent() {
        String A =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[4]/div")).getText();
        String B =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div/span")).getText();

        return "Indian Rupee".equals(A) && "Travel Allowance".equals(B);
    }
}
