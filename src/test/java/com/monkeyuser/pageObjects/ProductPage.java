package com.monkeyuser.pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.moneykey.testBase.BaseClass;

public class ProductPage extends BaseClass{

	// WebDriver driver;
	String price;

	public ProductPage (){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ul[@class='grid grid--uniform grid--view-items']/li[2]")
	WebElement product;

	@FindBy (xpath ="//button[@type='submit' and @name='add']")
	WebElement addToCart_btn;

	@FindBy(xpath = "//div[@class='product__price']/dl/div[1]/dd/span")
	WebElement product_price;


	public void ClickProduct() {
		product.click();
	}


	public String CheckProductPrice() {
		price =  product_price.getText().replaceAll("\\$", "");
		System.out.println("the price in producr details page is " +price);
		System.out.println("The price is " +price);
		return price;
	}

	public CartPage ClickAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(addToCart_btn));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart_btn));
		addToCart_btn.click();
		return new CartPage();
	}



}


