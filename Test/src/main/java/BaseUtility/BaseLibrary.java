package BaseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	
	public WebDriver driver;
	
    @BeforeMethod
    public WebDriver browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void getURL(String url){
 
    	    	
        driver.get(url);
        driver.manage().window().maximize();
        
    }
    
    @AfterMethod
    public void tearDownDriver(){
       
        driver.quit();
    }
	
	

}
