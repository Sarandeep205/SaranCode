package BaseUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	public WebDriver driver;
	public Properties prop;
	public String flipkartHomepageUrl = "flipkartUrl";
	public String amazonHomePageUrl = "amazonUrl";
	String searchProduct = "product";
	
	
    @BeforeMethod
    public WebDriver browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void enterURL(String url) throws IOException{
 
    	 prop= new Properties();
    	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\BaseUtility\\data.properties");
    	prop.load(fis);    	
        driver.get(prop.getProperty(url));
        driver.manage().window().maximize();
        
        
    }
    
    @AfterMethod
    public void tearDownDriver(){
        driver.close();
        driver.quit();
    }
	
	

}
