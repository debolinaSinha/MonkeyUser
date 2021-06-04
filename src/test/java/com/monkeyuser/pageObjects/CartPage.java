package com.monkeyuser.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.moneykey.testBase.BaseClass;

public class CartPage extends BaseClass {

	private  String subtotal;


	public  String getSubtotal() {
		return subtotal;
	}

	public  void setSubtotal(String subtotal) {

		this.subtotal = subtotal;
	}

	public CartPage () {
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//div[@id='CartCount']/span[1]")
	WebElement itemCountCart;

	@FindBy(css ="input#updates_large_11337199452196\\:0ba6dc1b4fa2ca7e0fad97d5a03e700c.cart__qty-input")
	WebElement quantity;

	@FindBy(xpath ="//input[@name=\"update\"]")
	WebElement update_btn;

	@FindBy(xpath = "//input[@name='checkout']")
	WebElement checkout_btn;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	WebElement cartP_price;

	@FindBy(xpath= ".//span[@class='cart-subtotal__price']")
	WebElement subtotal_price;


	public boolean productAddtoCart() {
		boolean quantitymatch=false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(quantity));
		//Thread.sleep(1000);
		String quantity = driver.findElement(By.cssSelector("input#updates_large_11337199452196\\:0ba6dc1b4fa2ca7e0fad97d5a03e700c.cart__qty-input")).getAttribute("value");
		String itemcount = itemCountCart.getText();
		System.out.println("The count in carts is: "+itemcount);
		System.out.println("The quantity  is: "+quantity);
		try {

			if( quantity.equals(itemcount)){
				System.out.println("The quantity of item in the cart icon matches with the product quantity");
				quantitymatch= true;
			}
			else {

				quantitymatch= false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();

		}
		return quantitymatch;

	}

	public boolean updateCart(String number) {
		quantity.clear();
		quantity.sendKeys(number);
		System.out.println("Increased the product count to 2");
		update_btn.click();
		System.out.println("Clicked on the update button");
		if( quantity.getAttribute("value").equals(itemCountCart.getText()) ){
			System.out.println("The quantity of item in the cart icon updates with the updated product quantity");
			return true;
		}
		else {
			return false;}
	}

	public String getTotalPriceAtCartPage() {
		Wait<WebDriver> wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(subtotal_price));
		return subtotal_price.getText().replaceAll("\\$", "");
	}

	public boolean verifyPrice(ProductPage _ProductPage) {

		String pPrice = _ProductPage.price;
		System.out.println("pPrice" +pPrice);
		System.out.println("The price of product from product detail page is captured");
		String CartPPrice = cartP_price.getText();
		CartPPrice = CartPPrice.replaceAll("\\$", "");
		System.out.println("CartPPrice" +CartPPrice);
		System.out.println("The price of the product from cart page is captured");
		double sub_total =Double.parseDouble(getTotalPriceAtCartPage().replaceAll("\\$", ""));
		System.out.println("subtotal" +sub_total);
		System.out.println("The subtotal  from the cart page is captured");
		if(CartPPrice.equals(pPrice)) {
			double TotalPrice = Double.parseDouble(quantity.getAttribute("value")) * Double.parseDouble(CartPPrice);
			System.out.println("The Total Price is captured by multipying quantity with item price");
			if(TotalPrice == sub_total) {
				System.out.println("The Total Price matches with the Subtotal in the Cart Page");
				return true;}
			else return false;
		}

		else {
			return false;
			}


	}

	public CheckOutPage CheckoutCart() {
		checkout_btn.click();
		System.out.println("Clicked on the Checkout Button from the Cart Page");
		return new CheckOutPage();
	}




}




