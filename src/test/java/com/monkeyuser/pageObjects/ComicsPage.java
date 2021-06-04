package com.monkeyuser.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneykey.testBase.BaseClass;

public class ComicsPage extends BaseClass {


	public ComicsPage () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Observer')]")
	public WebElement Randomcomic;
	
	@FindBy(xpath = "//div[@class = 'et']/strong")
	List <WebElement> ComicDateHeader;
	
	@FindBy(xpath="//a[contains(text(),'Trial And')]")
	WebElement dec4comic;
	
	public void OpenRandomComic() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Randomcomic);
		Randomcomic.click();
	}
	
	public String verifyComicPageTitle() {
		return driver.getTitle();
		
	}
	
	public ComicDetailPage OpenDec4Comic(WebDriver driver,String comicdate) {
		for(WebElement e : ComicDateHeader) {
			//System.out.println(e.getText());
			if(e.getText().contains(comicdate)) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", e);
				dec4comic.click();
				break;
			}
		}
		return new ComicDetailPage();
		
	}
}
