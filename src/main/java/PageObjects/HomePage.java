package PageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.WebUtil;

public class HomePage {
	
	public WebDriver driver;
	
	WebUtil webutil;
	
	By btn_Create = By.xpath("//p[text()='Create']/parent::button");
	
	By btn_CreateWorkspace = By.xpath("//span[text()='Create Workspace']/parent::button");
	
	By btn_CreateBoard = By.xpath("//span[text()='Create board']/parent::button");
	
	By field_workspaceName = By.xpath("//label[text()='Workspace name']/following-sibling::input");
	
	By choose_workspaceType = By.xpath("//div[contains(text(),'Choose')]");
	
	By otherWorkspace = By.xpath("//div[contains(@data-testid,'input-other')]");
	
	By description_workspace = By.xpath("//label[contains(@for,'description')]/following-sibling::textarea");
	
	By btn_workspaceContinue = By.xpath("//button[text()='Continue']");
	
	By doThisLater = By.xpath("//a[contains(text(),'do this later')]");

	By btn_createFirstBoard = By.xpath("//button[text()='Create your first board']");
	
	By input_boardTitle = By.xpath("//div[text()='Board title']/following-sibling::input");

	public HomePage(WebDriver driver)
	{
		
		this.driver = driver;
		
        webutil = new WebUtil(driver);
		
	}
	
	public By getBtn_Create() {
		
		return btn_Create;
	}

    public By getBtn_CreateWorkspace() {
		
		return btn_CreateWorkspace;
	}

    public By getField_workspaceName() {
    	
		return field_workspaceName;
	}

	public By getChoose_workspaceType() {
		
		return choose_workspaceType;
	}

	public By getOtherWorkspace() {
		
		return otherWorkspace;
	}

	public By getDescription_workspace() {
		
		return description_workspace;
	}

	public By getBtn_workspaceContinue() {
		
		return btn_workspaceContinue;
	}

	public By getDoThisLater() {
		
		return doThisLater;
	}
	
	public By getBtn_createFirstBoard() {
		
		return btn_createFirstBoard;
	}

	public By getInput_boardTitle() {
		
		return input_boardTitle;
	}

	public By getBtn_CreateBoard() {
		
		return btn_CreateBoard;
	}

	public void createWorkspace(String workspaceName,String description) 
	{
		webutil.waitForPageload();
		
		webutil.click(getBtn_Create());
		
		webutil.click(getBtn_CreateWorkspace());
		
		webutil.waitForPageload();
		
		webutil.clickClearAndInput(getField_workspaceName(),workspaceName);
		
		webutil.click(getChoose_workspaceType());
		
		webutil.click(getOtherWorkspace());
		
		webutil.clickClearAndInput(getDescription_workspace(), description);
		
		webutil.click(getBtn_workspaceContinue());
		
		webutil.waitForPageload();
		
		webutil.click(getDoThisLater());
		
		webutil.waitForPageload();
	}
	
	public void createBoard(String boardName)
	{	
        webutil.waitForPageload();
		
		webutil.click(getBtn_Create());
		
	    webutil.click(getBtn_CreateBoard());
	    
	    webutil.clickClearAndInput(getInput_boardTitle(),boardName);
	
	}
}
