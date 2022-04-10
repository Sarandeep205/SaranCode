package PageObjectFactory;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseUtility.BaseLibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipKartPage extends BaseLibrary {

	private WebDriverWait wait;

	public FlipKartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement popupClose;

	@FindBy(className = "_3704LK")
	private WebElement searchTextBox;

	@FindBy(className = "L0Z3Pu")
	private WebElement searchIconButton;

	@FindBy(xpath = "//div//*[@data-id]//a")
	private List<WebElement> firstProduct;

	@FindBy(xpath = "//div[@class='aMaAEs']/div/h1/span")
	private WebElement firstItemName;

	@FindBy(xpath = "//div[@class='_25b18c']/div")
	private WebElement firstProductPrice;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCart;

	@FindBy(xpath = "//button[text()='+']")
	private WebElement increaseProductButton;

	@FindBy(xpath = "//div[@class='Ob17DV _3X7Jj1']")
	private WebElement finalPrice;

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

	public void firstProduct() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firstProduct.get(0).click();
	}

	public String getFirstItemName() {
		wait.until(ExpectedConditions.visibilityOf(firstItemName));
		return firstItemName.getText();
	}

	public float firstProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
		return Float.parseFloat(firstProductPrice.getText().replaceAll("[₹,]", ""));

	}

	public void addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();

	}

	public void increaseProductButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(increaseProductButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", increaseProductButton);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		increaseProductButton.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public float finalPrice() {
		wait.until(ExpectedConditions.visibilityOf(finalPrice));
		return Float.parseFloat(finalPrice.getText().replaceAll("[₹,]", ""));

	}

}