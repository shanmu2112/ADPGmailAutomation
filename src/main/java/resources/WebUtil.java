package resources;

import java.time.Duration;
import java.util.List;

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
	
   public By getElement(String locator) {
		
		return By.xpath(locator);
		
	}
	
	public By getElement(String locator,String value) throws InterruptedException {
		
		Thread.sleep(4000);
		return By.xpath(locator.replace("key",value));
		
	}
	
	public List<WebElement> getElements(By locator){
		
		return driver.findElements(locator);
		
	}
	public boolean isElementPresent(By locator) {
		if(driver.findElements(locator).size()>0)
		{
			return true;
		}
		
		return false;
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    
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
		
		 public void mouseHoverUsingMoveToElement(WebElement element) {
		        
			 new Actions(driver).moveToElement(element).build().perform();
		        
		    }
	
		

	}
	

