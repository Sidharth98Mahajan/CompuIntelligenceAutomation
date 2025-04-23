package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.SupporteamPage;

public class AddSupportMemberTest extends LoginTest2 {
	    private SupporteamPage Support;
	    
	    
	    @BeforeTest
	    @Parameters("browser")
	    public void setup(String browser) {
	        super.setup(browser); // Initialize WebDriver for the specified browser
	        Support = new SupporteamPage(driver);
	        driver.get("https://dev-compuintelligence.compumailinc.com/");
	    }
	    
	    //Method To navigate to SupportTeam Module and Click on add member button.
	    @Test(priority=1)
	    public void addmember() {
	    	Support.ClickSupportTeamOption();
	    	Support.addmemeber();
	    }
	    
	    //Method to upload file
	    @Test(priority=2)
	    public void fileupload() {
	    	Support.uploadfile("C:\\Users\\Sidharath\\Downloads\\Donny+Martin.jpg");
	    	    	
	    }
	    
	    //Method to searchuser
	    @Test(priority=3)
	    public void usersearch() throws InterruptedException {
	    	Support.searchuser("Donny");
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	Support.selectuser();
	    	// Create an Actions instance to simulate key presses
	        Actions actions = new Actions(driver);
	        
	        // Press the Down Arrow key to highlight the first recommendation (Alexa Bliss)
	        actions.sendKeys(Keys.ARROW_DOWN).perform();  // Press down key once to highlight the first suggestion

	        // Press Enter key to select the highlighted recommendation
	        actions.sendKeys(Keys.ENTER).perform();
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        Thread.sleep(7000);
	     }
	    
	    //Method to handle First name is required Exception
	    @Test(priority=4)
	    public void verifyError() {
	    	// If error message is visible (e.g., User not found)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try {
                // Look for an error message on the page (customize the XPath based on actual error message element)
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@id=\"modalPopUperrorMessageText\"]") // Adjust the XPath based on actual error message
                ));

                // If error message is found, log the error and skip to the next method
                System.out.println("Error message found: " + errorMessage.getText());
            } catch (Exception innerException) {
                // If error message is not found, continue normal flow (rethrow exception if necessary)
                System.out.println("No error message found, continuing normal flow.");
            }
	    }
	    
	    //Method to add Title, Phone number and Description.
	    @Test(priority=5)
	    public void detailsAddition() {
	    	
	    	Support.adddata("Deveopment Lead", "(435) 254-4534", "Manages all Devalopment Ralated tasks");
	    	Support.clickSubmitt();
	    }
	    
}
