package org.example.tests;

import org.example.pages.LoginPage;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login"); // Ndrysho URL me atë të vërtetën
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        try {
            loginPage.enterUsername("testuser");
            loginPage.enterPassword("password123");
            loginPage.clickLogin();

            String expectedUrl = "https://example.com/dashboard"; // Ndrysho URL me atë të vërtetën
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");

        } catch (AssertionError e) {
            ScreenshotUtils.takeScreenshot(driver, "LoginTest_Failure");
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
