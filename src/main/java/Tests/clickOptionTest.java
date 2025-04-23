package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.clickmenuPage;



public class clickOptionTest extends LoginTest2 {
	  clickmenuPage clickmenu ;
	    
	    @Override
	    @BeforeTest
	    @Parameters("browser")
	    public void setup(String browser) {
	        super.setup(browser); // Initialize WebDriver for the specified browser
	        clickmenu = new clickmenuPage(driver);
	        driver.get("https://dev-compuintelligence.compumailinc.com/");
	    }
	    
	    @Test(priority=1)
	    public void ClickLeftBarOptions() {
	    	clickmenu.clickAllMenuOptionsAndPrintLinks();
	    }
}
