package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	 WebDriver driver;

	    // Locators for the username, password, login button, and error message
	    By usernameField = By.id("UserName");
	    By passwordField = By.id("Password");
	    By loginButton   = By.xpath("//*[@class='btn-login-section']");
	    By errorMessage  = By.xpath("//div[@class=\"alert-message alert-message-danger\"]");
	    By title         = By.xpath("//title");
        By Drop          = By.xpath("//span[@class=\"dropdown-title\"]");
        By Logout        = By.xpath("//ul[@class='dropdown-content']//li[a[text()='Log Out']]//a");
       
        
	    //Creating a constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Method to enter username, with clear before typing
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).clear();  // Clear the field before entering new value
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    // Method to enter password, with clear before typing
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();  // Clear the field before entering new value
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    // Method to click the login button
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    // Method to get the error message after login attempt
	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }
        // Method to get Title of page
	    public String getTitle() {
	    	return driver.findElement(title).getText();
	    }
	    
	    // Method to Click Drop down button as we have logout button inside dropdown
	    public void clickDrop() {
	        driver.findElement(Drop).click();
	    }
	    
	    // Method to click Logout Button
	    public void ClickLogout() {
	    	driver.findElement(Logout).click();
	    
	    }

	    // Combined method for login
	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }
	    
}