package com.moneykeyuser.testCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.moneykey.testBase.BaseClass;
import com.monkeyuser.pageObjects.ComicsPage;
import com.monkeyuser.pageObjects.HomePage;

public class TC_ViewRandomComic extends BaseClass{
	ComicsPage _comicPage;
	HomePage obj_homePage ;

	//Initializes home page and clicks on the comic list
	@BeforeMethod
	public void InitiliazeHomePage() {
		logger.info("Starting TC_ViewRandomComic");
		 obj_homePage = new HomePage();
		 logger.info("Initialised Home Page");
			try{
				 _comicPage= obj_homePage.ClickComicList();
				 logger.info("Clicked on Comic List on the Home Page");
			}
			catch(Exception e) {
				System.out.println("Comic List could not be clicked");
				logger.fatal("Could not click on Comic List on the Home Page");
			}
	}
	
	@Test(description="Views a random comic and checks the title of the comic")
	public void ViewAnyComic() {
		_comicPage.OpenRandomComic();
		logger.info("Clicked on a random comic");
		String title = _comicPage.verifyComicPageTitle();
		logger.info("Captured the title of a Comic Page");
		Assert.assertEquals(title, "Observer");
		logger.info("Finished executing TC_ViewRandomComics");

		}
		
		
		
}


