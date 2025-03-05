package org.example;

import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;

public class LogoutTest extends BaseTest {
    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeMethod
    public void setUpTest() {
        setup();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);

        // Login first
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test
    public void testLogout() {
        logoutPage.logout();
        Assert.assertTrue(logoutPage.isLogoutSuccessful(), "Logout failed!");
    }

    @AfterMethod
    public void tearDownTest() {
        Quit();
    }
}
