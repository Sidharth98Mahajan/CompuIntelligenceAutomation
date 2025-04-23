package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashBoard;

public class DashboardTest extends LoginTest2 {

    DashBoard dashboardPage;
    WebDriverWait wait;

    // This method will initialize the necessary dashboard page object
    @Override
    @BeforeTest
    public void setUp() {
        super.setUp();  // Call the setUp() method of LoginTest2 to handle login
        dashboardPage = new DashBoard(driver);  // Initialize dashboardPage
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @Test(priority = 2)
    public void verifyDashboard() {
        // Check if the dashboard element is visible after login
        boolean isVisible = isElementVisible(By.xpath("//div[@class='page-title']"));
        Assert.assertTrue(isVisible, "Dashboard element is not visible");
    }

    @Test(priority = 3)
    public void getDashboardOptions() {
        // Fetch the dashboard options and perform actions with them
        dashboardPage.getOptions();  // Assuming getOptions() retrieves the dashboard options
    }

    @Test(priority = 4)
    public void logoutFromDashboard() {
        // Call the logout method from LoginTest2 (inherited)
        logout();  // Using the inherited logout method
    }

    // Helper method to check if an element is visible on the page
    public boolean isElementVisible(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element != null && element.isDisplayed();
    }
}
