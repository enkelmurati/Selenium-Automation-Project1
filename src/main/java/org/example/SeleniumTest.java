package org.example; // Sigurohuni që emri i paketës është i saktë

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest { // Klasë e hapur
    public static void main(String[] args) { // Metoda e kryesore
        WebDriverManager.chromedriver().setup(); // Konfiguroni WebDriver për Chrome
        WebDriver driver = new ChromeDriver(); // Krijoni një instancë të ChromeDriver

        driver.get("https://www.google.com"); // Shkoni në faqen e Google
        System.out.println(driver.getTitle()); // Printoni titullin e faqes

        driver.quit(); // Mbyllni shfletuesin
    } // Mbyllet metoda e kryesore
} // Mbyllet klasa

