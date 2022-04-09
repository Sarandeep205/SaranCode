package Demo.Test;

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

import PageObjectFactory.AmazonPage;
import PageObjectFactory.FlipKartPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProgram {

	FlipKartPage flipKart;
	AmazonPage amazon;
	
	@Test
	public void First() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		flipKart = new FlipKartPage(driver);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		flipKart.popupClose();
		flipKart.searchTextBox("iphone 12 pro max");
		flipKart.searchIconButton();
		flipKart.firstProduct();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> win = windows.iterator();
		String parentWindow = win.next().toString();
		String childWindow = win.next().toString();	
		driver.switchTo().window(childWindow);
	
		System.out.println("Price of product - "+flipKart.firstProductPrice());
		flipKart.addToCart();	
		//flipKart.increaseProductButton();
		System.out.println("Total amount - "+flipKart.finalPrice());
		
		
			
		}

	@Test
	public void Second() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		amazon = new AmazonPage(driver);
		
		amazon.searchTextBox("APPLE iPhone 12 Pro Max (Silver, 128 GB)");
		amazon.searchIconButton();
		amazon.firstProduct();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> win = windows.iterator();
		String parentWindow = win.next().toString();
		String childWindow = win.next().toString();	
		driver.switchTo().window(childWindow);
		
		System.out.println("Price of product - "+amazon.firstProductPrice());
		
	/*	
		if(flipKart.firstProductPrice() > amazon.firstProductPrice())
		{
			System.out.println("Price of FlipKart  - "+flipKart.firstProductPrice());
			System.out.println("Price of amazon - "+amazon.firstProductPrice());
			System.out.println("FlipKart is costly");
		}
		else if(flipKart.firstProductPrice() < amazon.firstProductPrice())
		{
			System.out.println("Price of FlipKart  - "+flipKart.firstProductPrice());
			System.out.println("Price of amazon - "+amazon.firstProductPrice());
			System.out.println("amazon is costly");
		}
		else {
			System.out.println("Price is same");
		}
		*/	
		}
	
	
}
