package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;

    // Lokatorët
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    // Konstruktor
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodë për të shkruar në kutinë e kërkimit
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
    }

    // Metodë për të klikuar butonin e kërkimit
    public void clickSearchButton() {
        driver.findElement(searchButton).submit();
    }

    // Metodë për të marrë titullin e faqes
    public String getPageTitle() {
        return driver.getTitle();
    }
}
