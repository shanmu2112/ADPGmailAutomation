package Trello;

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
		
		basePage.loginPage(driver).loginToTrello();
				
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
	
	@Test
	public void dragCardAndfetchCardCoordinates() throws InterruptedException
	{
	 
	    basePage.homePage(driver).createWorkspace("Anywhere Works", "Help the world work anywhere");	
	    
	    basePage.homePage(driver).createBoard("Full Creative");
	    
	    basePage.boardPage(driver).archiveExistingList();
	    
	    basePage.boardPage(driver).createList("Office");
	    
	    basePage.boardPage(driver).createList("Remote");
	    
	    basePage.boardPage(driver).createCardinList("work1", "Office");
	    
	    basePage.boardPage(driver).createCardinList("work2", "Remote");
	    
	    basePage.boardPage(driver).dragCardFromOneListToAnother("work1", "Remote");
	    
	}

}
