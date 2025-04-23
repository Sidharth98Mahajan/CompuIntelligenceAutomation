package Tests;

import java.io.IOException;
import Utils.Screenshot; 
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Base;
import Pages.LoginPage;
import Utils.ExcelReader;

public class LoginTest extends Base {
    
    private LoginPage loginPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        super.setup(browser); // Initialize WebDriver for the specified browser
        loginPage = new LoginPage(driver);
        driver.get("https://dev-compuintelligence.compumailinc.com/");
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginData() throws IOException {
        return ExcelReader.getLoginData(); // Fetch login credentials from Excel
    }

    @Test(dataProvider = "loginCredentials")
    public void testLogin(String username, String password) {
        loginPage.login(username, password);
        //System.out.println("Credentials entered");
        
        
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        
        String ActualTitle  = "Welcome to Compu Intelligence";
        
        if(driver.getTitle().equalsIgnoreCase(ActualTitle)) {
        //System.out.println("Dashborad Reached");
        	// Capture a screenshot after successful login
        	Screenshot.captureScreenshot(driver, "dashboard_reached.png");
        	loginPage.clickDrop();
        	loginPage.ClickLogout();
        } else {
        	// If the login fails, capture a screenshot of the error page
            Screenshot.captureScreenshot(driver, "login_error.png");
        	
            // If the login fails, assert the error message
            Assert.assertTrue(loginPage.getErrorMessage().contains("Error! Invalid login attempt."));
            Assert.assertTrue(loginPage.getErrorMessage().contains("The User Name field is required."));
            Assert.assertTrue(loginPage.getErrorMessage().contains("The Password field is required."));
        }
    }

    @AfterTest
    public void tearDown() {
        super.tearDown(); // Close the browser after test execution
    }
}
