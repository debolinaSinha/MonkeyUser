package com.monkeyuser.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneykey.testBase.BaseClass;

public class ComicDetailPage extends BaseClass {
	
	//WebDriver driver;
	public ComicDetailPage(){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//img[@title ='Trial And']")
	WebElement ComicImg;
	
	@FindBy(tagName ="time")
	WebElement date;
	
	@FindBy(xpath ="//span[contains(text(),'dev')]")
	WebElement dev_lnk;
	
	@FindBy(xpath="//span[contains(text(),'bugs')]")
	WebElement bugs_lnk;
	
	@FindBy(xpath = "//span[contains(text(),'table')]")
	WebElement table_lnk;
	
	//This method verifies the comic Image
	public boolean VerifyComicimage() {
	if( ComicImg.isDisplayed() && date.getText().contains("04 DEC 2018") )
		return true;
	 else {return false;}
		
	}
	//This Method checks and clicks on the Dev radio button
	public boolean CheckDev(WebDriver driver)  {
		dev_lnk.click();
		
		if(driver.getCurrentUrl().contains("www.monkeyuser.com/tags/#dev"))
			return true;
		else{return false;}
		
	}
	
	//This method navigates the page back
	public void Navigateback(WebDriver driver) {
		driver.navigate().back();
	}
	
	//This Method checks and clicks on the Bugs radio button
	public boolean CheckBugs(WebDriver driver){
		bugs_lnk.click();
		
		if(driver.getCurrentUrl().contains("www.monkeyuser.com/tags/#bugs"))
			return true;
		else{return false;}
		
	}
	
	//This Method checks and clicks on the Table radio button
	public boolean CheckTable(WebDriver driver) {
		table_lnk.click();
		
		if(driver.getCurrentUrl().contains("www.monkeyuser.com/tags/#table"))
			return true;
		else{return false;}
		
	}
}
