package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.UsermanagementPage;
import Utils.ExcelReader;

public class UserManagemantTest extends LoginTest2  {
    private UsermanagementPage Usermanagemenrtpage;
    
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        super.setup(browser); // Initialize WebDriver for the specified browser
        Usermanagemenrtpage = new UsermanagementPage(driver);
        driver.get("https://dev-compuintelligence.compumailinc.com/");
    }
    
    @Test(priority=1)
    public void verifyvisibility() {
    	driver.findElement(By.xpath("//div[@class='menu-text' and text()='Configuration']")).click();
    }
    
    
    @Test(priority=2)
    public void navigateUM() {
    	       // Call methods from UsermanagementPage to click options
        Usermanagemenrtpage.clickUserManagementOption();  // Click the User Management option
        Usermanagemenrtpage.clickAddUser();  // Click the Add User option
    }
    
    @DataProvider(name = "UserManagementData")
    public Object[][] getUserdata() throws IOException {
        return ExcelReader.getUserdata(); // 
    }
    
    @Test(dataProvider = "UserManagementData",priority=3)
    public void testUserM(String username, String lastname, String phonenumber, String email) {
        Usermanagemenrtpage.enterdata(username, lastname, phonenumber, email); 
        
        // System.out.println("Credentials entered");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
