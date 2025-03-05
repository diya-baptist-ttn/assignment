package org.example;

import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        setup();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
