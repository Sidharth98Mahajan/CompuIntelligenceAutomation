package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SupporteamPage {
	
	WebDriver driver;
	
	
	//Locators to Navigate to Support module, upload user, enter details and click on save Button.
	By SupportOption = By.xpath("//div[text()='Support Team']");
	By AddMember = By.xpath("//a[@data-id=\"1\"]//div[@class='user-add-image']");
	By fileuploadbutton = By.xpath("//div[@class=\"single-action\"]//input[@id=\"fileUpload\"]");
	By SearchUserField = By.id("searchUser");
	By User = By.xpath("//ul[@id=\"searchUser_listbox\"]//li[1]//span[1]");
	By TitleField = By.id("txttitle");
	By PhoneField= By.id("txtPhoneNum");
	By descriptionfield = By.id("txtbio");
	By SubmittButton = By.xpath("//button[@class=\"btn btn-theme btn\"]");
	
	 
    //Creating a constructor
    public  SupporteamPage(WebDriver driver) {
	this.driver = driver;
    }
    
    //Method to click on Support Team Option
    public void ClickSupportTeamOption() {
    	driver.findElement(SupportOption).click();
    }
    
    //Method to perform file upload Action
    public void uploadfile(String filepath) {
    	try {
            // Optional: Only if the file input is hidden behind hover
            WebElement imageUploadSection = driver.findElement(By.id("imagePreview"));
            Actions actions = new Actions(driver);
            actions.moveToElement(imageUploadSection).perform();
            Thread.sleep(1000); // Wait briefly for hover effect to apply
            
            // Now wait for the input to be present (not necessarily visible)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(fileuploadbutton));
            
            // Upload the file using sendKeys (no click needed)
            fileInput.sendKeys(filepath);
            System.out.println("File uploaded successfully!");

        } catch (Exception e) {
            System.out.println("File upload failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    //Method to click on Add Support Team Member
    public void addmemeber() {
    	driver.findElement(AddMember).click();
    }
    
    //Method to search a user
    public void searchuser(String user) {
    	driver.findElement(SearchUserField).clear();
    	driver.findElement(SearchUserField).sendKeys(user);
   }
    
    //Below action will add first user when recomendations appear in dropdown when user is searched
	 public void selectuser() 
	 { 
		 driver.findElement(User).click();
		
	 }
	 
    //Method to add Title, Phonenumber, Description
    public void adddata(String Title, String phone, String description) {
    	driver.findElement(TitleField).clear();
    	driver.findElement(TitleField).sendKeys(Title);
    	driver.findElement(PhoneField).clear();
    	driver.findElement(PhoneField).sendKeys(phone);
    	driver.findElement(descriptionfield).clear();
    	driver.findElement(descriptionfield).sendKeys(description);
    }
    
    
    
    //Method to Click Submitt Button
    public void clickSubmitt() {
    	driver.findElement(SubmittButton).click();
    }


}
