package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class clickmenuPage {
    WebDriver driver;
    
    //Locator for parent list element
    By MenuOptions = By.cssSelector("ul#menu-top-menu li.menu-item a");

    // Constructor
    public clickmenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAllMenuOptionsAndPrintLinks() {
        List<WebElement> menuItems = driver.findElements(MenuOptions);

        for (int i = 0; i < menuItems.size(); i++) {
            // Re-fetch elements after navigating back to avoid stale element reference
            List<WebElement> refreshedMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(MenuOptions));

            WebElement option = refreshedMenu.get(i);
            String optionText = option.getText().replaceAll("[^a-zA-Z0-9]", "_"); // Clean file name

            option.click();

            // Wait for the page to load completely
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(webDriver -> ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState").equals("complete"));

            // Print page URL
            System.out.println("Clicked on: " + optionText + " | URL: " + driver.getCurrentUrl());
            
            
           // Wait for at least 10 seconds before taking the screenshot
            try {
                Thread.sleep(10000); // 10-second delay to ensure full content is loaded
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
            // Take a full-page screenshot
            takeFullPageScreenshot(optionText);

            // Navigate back to the homepage
            driver.navigate().to("https://dev-compuintelligence.compumailinc.com/Home");

            // Wait a little for the homepage to reload
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void takeFullPageScreenshot(String name) {
        // Check if the driver is a ChromeDriver (specific to Chrome)
        if (driver instanceof ChromeDriver) {
            // Using Chrome DevTools Protocol to capture a full-page screenshot
            ChromeDriver chromeDriver = (ChromeDriver) driver;
            String folderPath = "C:\\Users\\Sidharath\\eclipse-workspace\\CompuIntelligence\\src\\main\\resources\\Left menu Screenshots";
            new File(folderPath).mkdirs(); // Create folder if not exists

            String filePath = folderPath + "\\" + name + ".png";

            try {
                // Capture full-page screenshot using Chrome CDP
                byte[] screenshotData = chromeDriver.getScreenshotAs(OutputType.BYTES);
                FileUtils.writeByteArrayToFile(new File(filePath), screenshotData);
                System.out.println("Saved full-page screenshot: " + filePath);
            } catch (IOException e) {
                System.out.println("Failed to save screenshot for: " + name);
                e.printStackTrace();
            }
        } else {
            // Fallback to AShot for other browsers
            String folderPath = "C:\\Users\\Sidharath\\eclipse-workspace\\CompuIntelligence\\src\\main\\resources\\Left menu Screenshots";
            new File(folderPath).mkdirs(); // Create folder if not exists

            String filePath = folderPath + "\\" + name + ".png";

            try {
                Screenshot screenshot = new AShot()
                        .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Scrolling strategy
                        .takeScreenshot(driver);

                BufferedImage image = screenshot.getImage();
                ImageIO.write(image, "PNG", new File(filePath));
                System.out.println("Saved full-page screenshot: " + filePath);
            } catch (Exception e) {
                System.out.println("Failed to capture full-page screenshot for: " + name);
                e.printStackTrace();
            }
        }
    }
}
