package com.moneykeyuser.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.moneykey.testBase.BaseClass;
import com.monkeyuser.pageObjects.CartPage;
import com.monkeyuser.pageObjects.HomePage;
import com.monkeyuser.pageObjects.ProductPage;

public class TC_VerifyProductAddToCart extends BaseClass{
	ProductPage obj_ProductPage;
	HomePage obj_homePage;
	CartPage obj_CartPage;
	
	
	@Test(description= "Verifies a product can be added,updated to the cart.It also verifies the total price" )
	public void AddtoCart() throws InterruptedException  {
		 logger.info("Starting TC_VerifyProductAddToCart");
	     obj_homePage = new HomePage();
	     logger.info("Initialised Home Page");
	     obj_ProductPage = obj_homePage.BuyProductLink();
	     logger.info("Clicked on Buy Product Link from Home Page");
		 obj_ProductPage.ClickProduct();
		 logger.info("Clicked on a Product");
		 obj_ProductPage.CheckProductPrice();
		 logger.info("Checked Product Price");
		// obj_ProductPage.ClickAddToCart();
		 obj_CartPage = obj_ProductPage.ClickAddToCart();
		  //obj_CartPage = new CartPage();
		 logger.info("Clicked on Add to Cart from Product Detail Page");
		
		if(obj_CartPage.productAddtoCart()) {
			Assert.assertTrue(true);
			logger.info("Product is added to cart");
		}
		else {
			logger.fatal("The items in cart does not match with the item quantity in the Cart page");
			Assert.assertTrue(false);
		}
		if (obj_CartPage.updateCart("2")) {
			Assert.assertTrue(true);
			logger.info("The cart is updated");
		}
		else {
			//logger.fatal("The cart icon is not updated with the right quantity in the Cart page");
			Assert.assertTrue(false);
		}
		
		if(obj_CartPage.verifyPrice(obj_ProductPage)) {
			Assert.assertTrue(true);
		   logger.info("The Subtotal is calulated properly with increase in product count in the Cart Page ");
		}
		else {
			logger.fatal("The Subtotal is NOT calulated properly with increase in product count in the Cart Page");
			Assert.assertTrue(false);
		}
		logger.info("finished executing TC_VerifyProductAddToCart");

		
	}
	
}


