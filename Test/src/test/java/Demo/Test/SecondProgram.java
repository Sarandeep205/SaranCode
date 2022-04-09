package Demo.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class SecondProgram extends BaseLibrary{

	FlipKartPage flipKart;
	AmazonPage amazon;
	
	@Test
	public void First() throws InterruptedException, IOException {
		
	
		flipKart = new FlipKartPage(driver);
		enterURL(flipkartHomepageUrl);	
		
		flipKart.popupClose();
		flipKart.searchTextBox("APPLE iPhone 13Pro Max (Silver, 128 GB)");
		flipKart.searchIconButton();
		flipKart.firstProduct();

		CommonUtility.switchWindow(driver);

		
	
		System.out.println("Price of product - "+flipKart.firstProductPrice());
		float p = flipKart.firstProductPrice();
		System.out.println("P" + p);
		flipKart.addToCart();
		System.out.println("Total amount - "+flipKart.finalPrice());
			

		enterURL(amazonHomePageUrl);
		amazon = new AmazonPage(driver);
		
		amazon.searchTextBox("APPLE iPhone 13Pro Max (Silver, 128 GB)");
		amazon.searchIconButton();
		amazon.firstProduct();
		
		CommonUtility.switchWindow(driver);
		
		System.out.println("Amazon Product Price - "+amazon.firstProductPrice());
		float q = amazon.firstProductPrice();
		
System.out.println("q"+q);
System.out.println("P" + p);

		if(p > q)
		{
		
			System.out.println("FlipKart is costly");
			
		}
		else if(p < q)
		{
		
			System.out.println("amazon is costly");
		}
		else {
			System.out.println("Price is same");
		}
		
		}
	
	
}
