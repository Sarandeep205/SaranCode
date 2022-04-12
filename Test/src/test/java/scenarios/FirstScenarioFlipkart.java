package scenarios;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseUtility.BaseLibrary;
import BaseUtility.CommonUtility;
import PageObjectFactory.FlipKartPage;
import static TestingData.TestData.*;

public class FirstScenarioFlipkart extends BaseLibrary {

	FlipKartPage flipKart;

	@Test
	public void First() throws InterruptedException, IOException {

		getURL(getFlipkartUrl());
		flipKart = new FlipKartPage(driver);
		flipKart.popupClose();
		flipKart.searchTextBox(productName);
		flipKart.searchIconButton();
		flipKart.firstProduct();
		CommonUtility.switchWindow(driver);
		System.out.println("Name of first searched product in Flipkart - " + flipKart.getFirstItemName());
		System.out.println("Price of first searched product in Flipkart - " + flipKart.firstProductPrice());
		flipKart.addToCart();
		flipKart.increaseProductButton();
		System.out.println("Total amount needs to be paid to place order - " + flipKart.finalPrice());

	}
}
