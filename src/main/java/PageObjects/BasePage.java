package PageObjects;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



    public class BasePage {

    public WebDriver driver;

    public Properties prop = new Properties();
    
    public WebDriver initializeDriver() throws IOException
   	{
   		// TODO Auto-generated method stub
       	
       	String currentDirectory = System.getProperty("user.dir"); 
   		
       	String propertiesPath = currentDirectory + "\\src\\main\\java\\resources\\data.properties";
       	
       	FileInputStream fis = new FileInputStream(propertiesPath);
       	
   		prop.load(fis);
   		
   		String browser = prop.getProperty("browser");
   		
   		if ( browser.equalsIgnoreCase("chrome") )
   			
   		{
   			String chromeDriverPath = currentDirectory + "\\src\\main\\java\\resources\\chromedriver.exe";
   			
   			System.setProperty("webdriver.chrome.driver", chromeDriverPath );
   			
   			driver = new ChromeDriver ();
   			
   		}
   		
   		else if ( browser.equalsIgnoreCase( "firefox" ) )
   			
   		{
               String firefoxDriverPath = currentDirectory + "\\src\\main\\java\\resources\\geckodriver.exe";
   			
   			System.setProperty("webdriver.gecko.driver", firefoxDriverPath );
   			
   			driver = new FirefoxDriver ();
   			
   		}
   		
   		return driver;


   	}

    public WebDriver getDriver() 
    {
        return driver;
    }
    
    public LoginPage loginPage(WebDriver driver) throws IOException 
    {
    	System.out.println(driver);
        return new LoginPage(driver);
    }

     public HomePage homePage(WebDriver driver) 
     {
    	 return new HomePage(driver);
   
    }

     public BoardPage boardPage(WebDriver driver) 
     {
    	 return new BoardPage(driver);
     }
     
}