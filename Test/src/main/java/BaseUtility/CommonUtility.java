package BaseUtility;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


public class CommonUtility {

	   
    public static void switchWindow(WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String secondWindow: windows){
            driver.switchTo().window(secondWindow);
        }
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    
}
