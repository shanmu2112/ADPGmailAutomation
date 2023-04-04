package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.WebUtil;

public class LoginPage {
	
	    public WebDriver driver;
	    
	    WebUtil webutil;
	    
	    public Properties prop;
	    
	    By btn_signIn = By.xpath("//a[text()='Sign in']");
	    
	    By input_email = By.xpath("//input[@type='email']");
		
	    By btn_Next = By.xpath("//span[text()='Next']");
	    
	    By input_password = By.xpath("//input[@type='password']");
	    
     	By btn_NotNow =   By.xpath("//span[text()='Not now']");
     	
     	By logo_gmail = By.xpath("//img[contains(@src,'logo_gmail')]");
     	
		public By getBtn_signIn() {
			return btn_signIn;
		}

		public By getInput_email() {
			return input_email;
		}

		public By getBtn_Next() {
			return btn_Next;
		}

		public By getInput_password() {
			return input_password;
		}

		public By getBtn_NotNow() {
			return btn_NotNow;
		}

		public By getLogo_gmail() {
			return logo_gmail;
		}
		
		public LoginPage(WebDriver driver) throws IOException
	{
		
		this.driver = driver;
		
		webutil = new WebUtil(driver);
		
        String currentDirectory = System.getProperty("user.dir"); 
		
    	String propertiesPath = currentDirectory + "\\src\\main\\java\\resources\\data.properties";
    	
    	FileInputStream fis = new FileInputStream(propertiesPath);
    	
    	prop = new Properties();
    	
		prop.load(fis);
	}
		
		public boolean loginToGmail(String email,String password) {
			
			webutil.waitForPageload();
			
			webutil.clickClearAndInput(getInput_email(), email);
			
			webutil.click(getBtn_Next());
			
			webutil.clickClearAndInput(getInput_password(), password);
			
			webutil.click(getBtn_Next());
			
			webutil.waitForPageload();
			
			if(webutil.isElementPresent(getBtn_NotNow())) {
				
				webutil.click(getBtn_NotNow());
			}
			
			webutil.waitForPageload();
			
			if(webutil.isElementPresent(getLogo_gmail())) {
				
				return true;
			}
			
			return false;
			
		}

		
	
		
}
