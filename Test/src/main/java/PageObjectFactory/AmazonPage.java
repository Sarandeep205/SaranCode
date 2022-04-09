package PageObjectFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchIconButton;

	@FindBy(xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")
	private WebElement firstProduct;

	@FindBy(xpath = "//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")
	private WebElement firstProductPrice;
	
	
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
		
		

}