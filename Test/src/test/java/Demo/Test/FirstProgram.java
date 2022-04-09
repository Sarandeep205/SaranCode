package Demo.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseUtility.BaseLibrary;
import BaseUtility.CommonUtility;
import PageObjectFactory.AmazonPage;
import PageObjectFactory.FlipKartPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstProgram extends BaseLibrary{

	FlipKartPage flipKart;
	
	@Test
	public void First() throws InterruptedException, IOException {
		
		enterURL(flipkartHomepageUrl);
		flipKart = new FlipKartPage(driver);	
		flipKart.popupClose();
		flipKart.searchTextBox("iphone 12 pro max");
		flipKart.searchIconButton();
		flipKart.firstProduct();

		CommonUtility.switchWindow(driver);
	
		System.out.println("Price of product - "+flipKart.firstProductPrice());
		flipKart.addToCart();	
 
		flipKart.increaseProductButton();
		System.out.println("Total amount - "+flipKart.finalPrice());
		
			
		}
	
}
