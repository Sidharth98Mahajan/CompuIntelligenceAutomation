package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.Base;
import Utils.ConfigReader;
import Pages.LoginPage;

public class LoginTest2 extends Base {

    ConfigReader configReader;
    LoginPage loginPage;

    // Initialize ConfigReader and LoginPage in @BeforeClass
    @BeforeClass
    public void setUp() {
        // Initialize ConfigReader to read properties from the config file
        configReader = new ConfigReader();

        // Navigate to the login page URL
        driver.get(configReader.getURL());

        // Initialize LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test(priority=0)
    public void testLoginWithValidCredentials() {
        // Fetch username and password from ConfigReader
        String username = configReader.getUsername();
        String password = configReader.getPassword();

        // Perform login with credentials from config.properties
        loginPage.login(username, password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //loginPage.clickLogin();
    }

    @Test(priority=5)
    public void logout() {
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	loginPage.clickDrop();
    	loginPage.ClickLogout();
    	
    }
    
    @AfterTest
    public void tearDown() {
        super.tearDown(); // Close the browser after test execution
    }

}

