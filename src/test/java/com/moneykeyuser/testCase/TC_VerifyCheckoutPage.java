package com.moneykeyuser.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.moneykey.testBase.BaseClass;
import com.monkeyuser.pageObjects.CartPage;
import com.monkeyuser.pageObjects.CheckOutPage;
import com.monkeyuser.pageObjects.HomePage;
import com.monkeyuser.pageObjects.ProductPage;

public class TC_VerifyCheckoutPage extends BaseClass {
	ProductPage obj_ProductPage;
	HomePage obj_homePage;
	CartPage obj_CartPage;
	CheckOutPage obj_CheckOutPage;

	@BeforeMethod
	public void init() {
		logger.info("Started test TC_VerifyCheckoutPage");
		obj_homePage = new HomePage();
		logger.info("Home Page is initialized");
		obj_ProductPage = obj_homePage.BuyProductLink();
		logger.info("Clicked on buy product link in Home Page");
		obj_ProductPage.ClickProduct();
		logger.info("Clicked on a product");
	}

	@Test(description ="This method checks the checkoutpage functionality and verifies the total price with the cart page")
	public void json() throws InterruptedException {
		obj_CartPage = obj_ProductPage.ClickAddToCart();
		logger.info("Item added to cart");
		Thread.sleep(1000);
		String priceAtCartPage = obj_CartPage.getTotalPriceAtCartPage();
		logger.info("Gets total price at Cart Page");
		
		obj_CheckOutPage = obj_CartPage.CheckoutCart();
		obj_CheckOutPage.readWriteJSON();
		logger.info("Entered users information in the Checkout Page");
		String priceAtCheckOutPage = obj_CheckOutPage.getTotalPriceAtCheckOut();
		logger.info("Gets total price at Checkout Page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(priceAtCheckOutPage,priceAtCartPage ,"Cart Page and CheckOut page subtotal value not matched.");
		obj_CheckOutPage.shippingClick();
		logger.info("Clicked on continue to Shipping button");
		String title = obj_CheckOutPage.getShippingPageTitle();
		softAssert.assertEquals(title, "Shipping - Monkeyuser - Checkout");
		softAssert.assertAll();
	}
}
