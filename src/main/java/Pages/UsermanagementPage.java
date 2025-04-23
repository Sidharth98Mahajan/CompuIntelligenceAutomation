package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsermanagementPage {
 WebDriver driver;
 
       //Locators needed to navigate to Usermanagement page and add data bases on Username, last name , role , Phone number , role and Email
       By UserManagement = By.xpath("//a[@href='/Configuration/UserManagement']");
       By AddUSer        = By.xpath("//*[@class='btn-theme btn modal-add-user']");
       By Username       = By.id("txtfName");
       By LastName       = By.id("txtlName");
       By PhoneNumber    = By.id("txtPhoneNum");
       By Role           = By.id("Role_id");
       By Email          = By.id("txtEmail");
       By SaveContinue   = By.id("saveProfileBtn");
       By Selectrole     = By.xpath("//*[@id=\"Role_id\"]/option[text()='Service Provider Admin']");
       
    //Creating Constructor
    public  UsermanagementPage(WebDriver driver) {
    	this.driver= driver;
    }
    // Method to Click User Management Option
    public void clickUserManagementOption() {
    	driver.findElement(UserManagement).click();
    }
    // Method to click Add User Option
    public void clickAddUser() {
    	driver.findElement(AddUSer).click();	
    }
    // Method to Enter FirstName
    public void addFirstName(String username) {
    	driver.findElement(Username).sendKeys(username);
    }
    // Method to Enter Last name
    public void addLastName(String lastname) {
    	driver.findElement(LastName).sendKeys(lastname);
    }
    // Method to Enter Phone Number
    public void addPhoneNumber(String phonenumber) {
    	driver.findElement(PhoneNumber).sendKeys(phonenumber);
    }
    // Method to Enter Email
    public void addEmail(String email) {
    	driver.findElement(Email).sendKeys(email);
    }
    // Method to click Save Button
    public void clickSave() {
    	driver.findElement(SaveContinue).click();
    }
    // Method to click Role
    public void clickRole() {
    	driver.findElement(Role).click();
    }
    
    // Method to Select Role
    public void clickSelectRole() {
    	driver.findElement(Selectrole).click();
    }
    
    // combined Method to add entire data
    public void enterdata(String username, String lastname, String phonenumber, String email) {
    	addFirstName(username);
    	addLastName(lastname);
    	addPhoneNumber(phonenumber);
    	addEmail(email);
    	clickRole();
    	clickSelectRole();
    	clickSave();
    	}
 
}
