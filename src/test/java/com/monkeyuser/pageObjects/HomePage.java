package com.monkeyuser.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneykey.testBase.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="COMICS LIST")
	public WebElement comicList_link;
	
	@FindBy(xpath ="//header/div[1]/div[4]/a[2]")
	public WebElement buyProduct_link;
	
	//method to click comicList and go to Comics page
	public ComicsPage ClickComicList() {
		comicList_link.click();
		return new ComicsPage();
	}
	
	
	// Method to click Buy Plushies
	public ProductPage BuyProductLink() {
		buyProduct_link.click();
		return new ProductPage();
     }
	
	
}
