package org.example;

import org.example.base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.ClaimPage;
import org.example.pages.LoginPage;

public class ClaimTest extends BaseTest {
    LoginPage loginPage;
    ClaimPage claimPage;

    @BeforeMethod
    public void setUpTest() {
        setup();
        loginPage = new LoginPage(driver);
        claimPage = new ClaimPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test
    public void testCreateClaim() {
        claimPage.goToClaims();
        claimPage.createClaim();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
