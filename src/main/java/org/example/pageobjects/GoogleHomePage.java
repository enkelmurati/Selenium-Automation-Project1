package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;

    // Elementi i fushës së kërkimit
    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda për të kërkuar
    public void search(String query) {
        WebElement searchField = driver.findElement(searchBox);
        searchField.sendKeys(query);
        searchField.submit();
    }
}
