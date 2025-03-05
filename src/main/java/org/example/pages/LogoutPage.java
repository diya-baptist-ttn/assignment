package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    private By profileDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By loginPageTitle = By.xpath("//h5[text()='Login']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(profileDropdown).click();
        driver.findElement(logoutButton).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.findElement(loginPageTitle).isDisplayed();
    }
}
