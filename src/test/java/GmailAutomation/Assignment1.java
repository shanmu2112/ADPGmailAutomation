package GmailAutomation;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import resources.WebUtil;

public class Assignment1 extends BasePage{
	
	public static BasePage basePage = new BasePage();
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
        driver = initializeDriver();
        
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		
				
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
	
	@Test
	public void assignment1() throws IOException, InterruptedException
	{
		basePage.loginPage(driver).loginToGmail(prop.getProperty("userID"), prop.getProperty("password"));
		
		basePage.homePage(driver).createNewLabel("Label1");
		
		basePage.homePage(driver).renameLabel("Label1", "Label2");
		
		basePage.homePage(driver).listAllLabels();
		
	}
	

}
