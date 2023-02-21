package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.WebUtil;

public class BoardPage {
	
	public WebDriver driver;
	
	WebUtil webutil;
	
	By lst_optionsMenu = By.xpath("//a[contains(@class,'list') and contains(@class,'menu')]");
	
	By archiveList = By.xpath("//a[text()='Archive this list']");
			
	By addList = By.xpath("//a[contains(@class,'list') and contains(@class,'add')]");
	
	String input_listName = "//input[contains(@class,'list') and contains(@class,'name')]";
	
	By btn_addList = By.xpath("//input[contains(@class,'list') and contains(@class,'add')]");
	
	String btn_addCard = "//h2[text()='key']/parent::div[contains(@class,list) and contains(@class,'header')]/following-sibling::div/a[contains(@class,'card')]";
	
	String txtArea_CardName = "//textarea[contains(@placeholder,'Enter a title for this card')]";
	
	By input_addCard = By.xpath("//input[@value='Add card']");
	
	String element_card = "//a[contains(@class,'list-card') and contains(@href,'key')]";
	
	String listName = "//h2[text()='key']/parent::div";
	
	public String getListName() {
		return listName;
	}

	public By getLst_optionsMenu() {
		return lst_optionsMenu;
	}

	public By getArchiveList() {
		return archiveList;
	}
	
	public By getAddList() {
		return addList;
	}


	public String getInput_listName() {
		return input_listName;
	}


	public By getBtn_addList() {
		return btn_addList;
	}


	public String getBtn_addCard() {
		return btn_addCard;
	}


	public String getTxtArea_CardName() {
		return txtArea_CardName;
	}


	public By getInput_addCard() {
		return input_addCard;
	}


	public String getElement_card() {
		return element_card;
	}


	public BoardPage(WebDriver driver) 
{
	
	this.driver = driver;
	
	webutil = new WebUtil(driver);
}
	
	public void archiveExistingList()
	{
		while(webutil.isElementPresent(getLst_optionsMenu()))
		{
			webutil.waitForPageload();
			
			webutil.click(getLst_optionsMenu());
			
			webutil.click(getArchiveList());
			
			webutil.waitForPageload();
		}
		
	}

	public void createList(String listName) throws InterruptedException 
	{
		webutil.waitForPageload();
		
		webutil.clickUsingJavaScript(getAddList());
		
		webutil.typeUsingActionApi(getInput_listName(),"",listName);
		
		//webutil.clickClearAndInput(getInput_listName(),listName);
		
		webutil.click(getBtn_addList());
	}
	
	public void createCardinList(String cardName, String listName) throws InterruptedException
	{
		WebElement element = webutil.getElement(getBtn_addCard(),listName); 
		
		webutil.click(element);
		
		webutil.typeUsingActionApi(getTxtArea_CardName(),"", cardName);
		
		//webutil.clickClearAndInput(getTxtArea_CardName(),cardName);
		
		webutil.click(getInput_addCard());
		
		webutil.waitForPageload();
		
	}
	
	public void dragCardFromOneListToAnother(String cardName,String list2) throws InterruptedException
	{
		WebElement source = webutil.getElement(getElement_card(),cardName);
		
		WebElement target = webutil.getElement(getListName(),list2);
		
		webutil.dragAndDrop(source, target);
		
		webutil.click(target);
		
		System.out.println("X Coordinate: "+webutil.fetchXCo0rdinate(webutil.getElement(getElement_card(),cardName)));
		
		System.out.println("Y Coordinate: "+webutil.fetchYCo0rdinate(webutil.getElement(getElement_card(),cardName)));
	}

}