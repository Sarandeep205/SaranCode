package PageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseUtility.BaseLibrary;

public class AmazonPage extends BaseLibrary{

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

	@FindBy(css = " div h2 a span")
	private List<WebElement> searchResult;

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

	public float firstProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
		return Float.parseFloat(firstProductPrice.getText().replaceAll("[₹,]", ""));

	}

	public List<WebElement> getAllItems() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResult.get(0)));
		return searchResult;
	}

}