package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;

    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void search(String query) {
        WebElement searchField = driver.findElement(searchBox);
        searchField.sendKeys(query);
        searchField.submit();
    }
}
