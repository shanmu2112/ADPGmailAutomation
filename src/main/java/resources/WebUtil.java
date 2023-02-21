package resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {

	WebDriver driver;
	int waitTimeUpperLimitInSeconds = 60;

	public WebUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement getElement(String locator,String value) throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(By.xpath(locator.replace("key",value)));
	}
	public boolean isElementPresent(By locator) {
		if(driver.findElements(locator).size()>0)
		{
			return true;
		}
		
		return false;
	}
	
	 public void typeUsingActionApi(String locator, String value, String testData) throws InterruptedException {
	        testData = testData.toString().trim();
	        Actions actions = new Actions(driver);
	        actions.click(getElement(locator, value));
	        actions.sendKeys(testData).build().perform();
	    }

	 
	public void click(WebElement element) {
		element.click();
	}
	
	public void click(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		click(element);
	}
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void clickUsingJavaScript(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void clickClearAndInput(WebElement element, String data) {
		try {
			click(element);
			clear(element);
			element.sendKeys(data);
			Thread.sleep(5000);
			element.sendKeys(Keys.RETURN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickClearAndInput(By locator, String data) {
		try {
			WebElement element = getElement(locator);
			click(element);
			clear(element);
			element.sendKeys(data);
			Thread.sleep(5000);
			element.sendKeys(Keys.RETURN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		public void waitForPageload() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int i = 0;
			try {
				Thread.sleep(3000);
			while (i < 20) {
				String state = (String) js.executeScript("return document.readyState;");

				if (state.equals("complete"))
					break;
				else
					Thread.sleep(1000);

				i++;
			}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		public void dragAndDrop(WebElement source, WebElement target) throws InterruptedException {
			Actions actions = new Actions(driver);
			//action.dragAndDrop(source, target).perform();;
			Action action = actions.moveToElement(target).clickAndHold(source).pause(Duration.ofSeconds(3)).moveToElement(target).release(target).pause(Duration.ofSeconds(3)).build();
			action.perform();
			Thread.sleep(2000);

		}
		
		public int fetchXCo0rdinate(WebElement element) 
		{
			return element.getLocation().getX();
		}
		
		public int fetchYCo0rdinate(WebElement element) 
		{
			return element.getLocation().getY();
		}

	}
	

