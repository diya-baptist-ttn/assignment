package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClaimPage {
    WebDriver driver;

    private By claimMenu = By.xpath("(//a[@class='oxd-main-menu-item'])[10]");
    private By createClaimButton = By.xpath("//a[text()='Submit Claim']");
    private By claimEvent = By.name("(//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error'])[1]");
    private By claimCurrency = By.name("(//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error'])[2]");
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
        driver.findElement(createClaimButton).click();
        WebElement Event= driver.findElement(claimEvent);
        Select dropdown = new Select(Event);
        dropdown.selectByVisibleText("Travel Allowance");

        WebElement Event1= driver.findElement(claimCurrency);
        Select dropdown1 = new Select(Event1);
        dropdown1.selectByVisibleText("Indian Rupee");
        driver.findElement(submitClaimButton).click();
    }

    public void goToMyClaims() {
        driver.findElement(myClaimsMenu).click();
    }

    public boolean isClaimPresent(String title) {
        return driver.findElement(firstClaimTitle).getText().equals(title);
    }
}
