package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Krijo folderin "screenshots" nëse nuk ekziston
            Files.createDirectories(Paths.get("screenshots"));

            // Merr screenshot-in
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Gjenero emrin e skedarit me timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destinationFile = new File("screenshots/" + fileName + "_" + timestamp + ".png");

            // Ruaj skedarin
            Files.copy(screenshot.toPath(), destinationFile.toPath());
            System.out.println("Screenshot saved: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
