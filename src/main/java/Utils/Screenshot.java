package Utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {

    /**
     * Capture a screenshot and save it to a specified location.
     * @param driver WebDriver instance
     * @param filePath The path to save the screenshot file
     */
    public static void captureScreenshot(WebDriver driver, String filePath) {
        // Take screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        
        // Specify the directory path
        String directoryPath = "C:\\Users\\Sidharath\\eclipse-workspace\\CompuIntelligence\\src\\main\\resources\\Screenshots";
        
        // Ensure the directory exists
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            dir.mkdirs();  // Create the directory if it doesn't exist
        }

        // Define the destination file path (including the filename)
        File destinationFile = new File(directoryPath + File.separator + filePath);
        
        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }

    /**
     * Capture a screenshot with a default filename.
     * @param driver WebDriver instance
     */
    public static void captureScreenshot(WebDriver driver) {
        String defaultFilePath = "screenshot.png";  // Default file name
        captureScreenshot(driver, defaultFilePath);
    }
}
