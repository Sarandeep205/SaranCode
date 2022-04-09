package BaseUtility;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {

	   
    public static void switchWindow(WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String secondWindow: windows){
            driver.switchTo().window(secondWindow);
        }
        waitForLoad(driver);
    }

    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
    
    /*
         public void navigateAndTakeControlToNewTab(int tabNumber)
	    {
	    	ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs1.get(tabNumber+1));
	    }
     */
    
    
}
