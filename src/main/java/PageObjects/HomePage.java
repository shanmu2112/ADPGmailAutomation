package PageObjects;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.WebUtil;

public class HomePage {
	
	public WebDriver driver;
	
	WebUtil webutil;
	
	By btn_closePopup = By.xpath("//button[@aria-label='Close']");
	
	By btn_createLabel = By.xpath("//div[@aria-label='Create new label']");
	
	By input_labelName = By.xpath("//label[text()='Please enter a new label name:']/parent::div/following-sibling::input");
	
	By btn_create = By.xpath("//button[contains(text(),'Create')]");
	
	String link_label = "//a[contains(@href,'label') and text()='key']";
	
	By allLink_label = By.xpath("//a[contains(@href,'label')]");

	By icon_threeDotLabel = By.xpath("//div[@data-label-name='abc']");
	
	By edit_label = By.xpath("//div[text()='Edit']");
	
	By save_label = By.xpath("//button[contains(text(),'Save')]");
	
	public By getBtn_closePopup() {
		
		return btn_closePopup;
	}

	public By getBtn_createLabel() {
		
		return btn_createLabel;
	}

	
	public By getInput_labelName() {
		
		return input_labelName;
	}

	
	public By getBtn_create() {
		
		return btn_create;
	}
	
	public String getLink_label() {
		
		return link_label;
	}	

	public By getIcon_threeDotLabel() {
		
		return icon_threeDotLabel;
	}

	public By getEdit_label() {
		
		return edit_label;
	}
	
	public By getSave_label() {
		
		return save_label;
	}
	
	public By getAllLink_label() {
		
		return allLink_label;
		
	}

	public HomePage(WebDriver driver)
	{
		
		this.driver = driver;
		
        webutil = new WebUtil(driver);
		
	}
	
	
	//At certain cases, we can freeze web page after a specific timelimit! Type setTimeout(function(){debugger;},5000); and press Enter in Console ! This command will freeze webpage after 5 seconds, we can inspect elements after that.

    public boolean createNewLabel(String label) throws InterruptedException {
    	
    	webutil.click(getBtn_createLabel());
    	
    	webutil.clickClearAndInput(getInput_labelName(),label);
    	
    	webutil.click(getBtn_create());
    	
    	if(webutil.isElementPresent(webutil.getElement(getLink_label(),label)))
    	{
    		return true;
    	}
    	
    	return false;
    	
    }
    
    public boolean renameLabel(String oldLabelName, String newLabelName) throws InterruptedException {
    	
        boolean labelNameChanged = webutil.isElementPresent(webutil.getElement(getLink_label(), newLabelName));
        if(labelNameChanged) {
        	
        	return true;
        }
    	return false;
    }
    
    public void listAllLabels(){
    	
    	List<WebElement> allLabels = webutil.getElements(getAllLink_label());
    	
    	for(WebElement label: allLabels) {
    		
    		System.out.println(label.getText());
    		
    	}
    	
    }	
		
}
