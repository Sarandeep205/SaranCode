package PageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipKartPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public FlipKartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement popupClose;

	@FindBy(className = "_3704LK")
	WebElement searchTextBox;

	@FindBy(className = "L0Z3Pu")
	WebElement searchIconButton;

	@FindBy(xpath = "(//div[@class='_4rR01T'])[1]")
	WebElement firstProduct;

	@FindBy(xpath = "//div[@class='_25b18c']/div")
	WebElement firstProductPrice;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCart;

	@FindBy(xpath = "//button[text()='+']")
	WebElement increaseProductButton;

	@FindBy(xpath = "//div[@class='Ob17DV _3X7Jj1']")
	WebElement finalPrice;

	public void popupClose() {
		wait.until(ExpectedConditions.visibilityOf(popupClose));
		popupClose.click();
		
	}
	
	public void searchTextBox(String searchText) {
		wait.until(ExpectedConditions.visibilityOf(searchTextBox));
		searchTextBox.sendKeys(searchText);
		
	}
	
	public void searchIconButton() {
		wait.until(ExpectedConditions.visibilityOf(searchIconButton));
		searchIconButton.click();	
		
	}
	
	public void firstProduct() {
		wait.until(ExpectedConditions.visibilityOf(firstProduct));
		firstProduct.click();	
		
	}
	

	public float firstProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
		return Float.parseFloat(firstProductPrice.getText().replaceAll("[₹,]", ""));
		
	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOf(addToCart));
		addToCart.click();	
		
	}
	
	public void increaseProductButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(increaseProductButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", increaseProductButton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	wait.until(ExpectedConditions.visibilityOf(increaseProductButton));
		increaseProductButton.click();	
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	public float finalPrice() {
		wait.until(ExpectedConditions.visibilityOf(finalPrice));
		return Float.parseFloat(finalPrice.getText().replaceAll("[₹,]", ""));
	        //return Integer.valueOf(finalPrice.getText().replaceAll("[^\\d]", ""));
	       /* price = price.replaceAll("[₹,]","");
			 float cartFloatPrice = Float.parseFloat(price);
		*/
	}
	

}