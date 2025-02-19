package org.example.tests;

import org.example.pages.GoogleSearchPage;
import org.example.utils.ScreenshotUtils;
import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void testGoogleSearch() {
        try {
            googleSearchPage.enterSearchTerm("OpenAI");
            googleSearchPage.clickSearchButton();

            // Përdorim WaitUtils për të pritur ngarkimin e faqeve
            WaitUtils.waitForElementToBeVisible(driver, driver.findElement(org.openqa.selenium.By.id("search")));

            String title = googleSearchPage.getPageTitle();
            Assert.assertTrue(title.contains("OpenAI"), "Titulli i faqes nuk përmban 'OpenAI'");
        } catch (AssertionError e) {
            ScreenshotUtils.takeScreenshot(driver, "GoogleSearchTest_Failure");
            throw e;
        }
    }
}

