package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoard {
    WebDriver driver;

    // Locator for options in the dashboard
    By Options = By.xpath("//*[@id='menu-top-menu']/li/a/div[@class='menu-text']");

    // Constructor
    public DashBoard(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the options from the menu
    public void getOptions() {
        // Finding multiple elements matching the XPath
        List<WebElement> opt = driver.findElements(Options);

        // Iterating over the options and printing the text (or performing other actions)
        for (WebElement option : opt) {
            System.out.println(option.getText());  // Printing the text of each option
        }
    }
}
