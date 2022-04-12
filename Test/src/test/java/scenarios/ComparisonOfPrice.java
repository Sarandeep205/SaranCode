package scenarios;

import static TestingData.TestData.*;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import BaseUtility.BaseLibrary;
import BaseUtility.CommonUtility;
import PageObjectFactory.AmazonPage;
import PageObjectFactory.FlipKartPage;

public class ComparisonOfPrice extends BaseLibrary {

	FlipKartPage flipKart;
	AmazonPage amazon;

	@Test
	public void First() throws InterruptedException, IOException {

		getURL(getFlipkartUrl());
		flipKart = new FlipKartPage(driver);
		flipKart.popupClose();
		flipKart.searchTextBox(productName);
		flipKart.searchIconButton();
		flipKart.firstProduct();
		CommonUtility.switchWindow(driver);
		String productInFlipkart = flipKart.getFirstItemName();
		float firstProductPrice = flipKart.firstProductPrice();
		flipKart.addToCart();
		System.out.println("Price of first searched product in Flipkart - " + flipKart.finalPrice());
		getURL(getAmazonUrl());
		amazon = new AmazonPage(driver);
		amazon.searchTextBox(productInFlipkart);
		amazon.searchIconButton();
		String[] itemNameArray = productInFlipkart.replaceAll("[^A-Z a-z 0-9 \" \"]", "").toLowerCase().split(" ");
		List<WebElement> allSearchResult = amazon.getAllItems();
		for (WebElement e : allSearchResult) {
			String itemName = e.getText().replaceAll("[^A-Z a-z 0-9 \" \"]", "").toLowerCase();
			boolean found = false;

			for (String eachWord : itemNameArray) {

				found = itemName.contains(eachWord) ? true : false;

			}

			if (found == true) {
				e.click();
				CommonUtility.switchWindow(driver);
			}
			break;
		}
		System.out.println("Price of first searched product in Amazon - " + amazon.firstProductPrice());
		float amazonProductPrice = amazon.firstProductPrice();

		if (firstProductPrice > amazonProductPrice) {

			System.out.println("FlipKart Product is costly");

		} else if (firstProductPrice < amazonProductPrice) {

			System.out.println("Amazon Product is costly");
		} else {
			System.out.println("Price is same");
		}

	}

}
