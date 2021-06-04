package com.moneykeyuser.testCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.moneykey.testBase.BaseClass;
import com.monkeyuser.pageObjects.ComicDetailPage;
import com.monkeyuser.pageObjects.ComicsPage;
import com.monkeyuser.pageObjects.HomePage;

public class TC_ViewDecComic extends BaseClass {
	
	HomePage obj_homePage;
	ComicsPage obj_comicspage ;
	ComicDetailPage obj_ComicDetailPage;

	@BeforeMethod
	public void HomePageInit() {
		 logger.info("Starting TC_ViewDecComic");
		 obj_homePage = new HomePage();
		 logger.info("Home Page initialised");
		try { obj_comicspage= obj_homePage.ClickComicList();
			logger.info("Clicked Comic List Link from  Home Page");
			}
		catch(Exception e) {
				logger.fatal("Comic List could not be clicked");
				e.printStackTrace();}
				
	}
	
	@Test(description = "Opens the comics for December 4, 2018 and verifies each comics")
	public void ViewDateComic() {
		
		obj_ComicDetailPage = obj_comicspage.OpenDec4Comic(driver,"December 4, 2018");
		logger.info("Opens the comics for December 4, 2018");
		if(obj_ComicDetailPage.VerifyComicimage()) {
			Assert.assertTrue(true);
			logger.info("Comic image is verified");}
		else {
			Assert.assertTrue(false);
			logger.fatal("Comic image could not be located");
			}
		
		if(obj_ComicDetailPage.CheckDev(driver)){
			Assert.assertTrue(true);
			logger.info("The dev Link in the Comic Detail Page is Checked");
			obj_ComicDetailPage.Navigateback(driver);
			logger.info("Navigate back to the Comic Detail page");}
		else {Assert.assertTrue(false);
		    logger.fatal("The dev link could not be found on the Comic Detail Page");}
		
		if(obj_ComicDetailPage.CheckBugs(driver)){
			Assert.assertTrue(true);
			logger.info("The Bugs Link in the Comic Detail Page is Checked");
			obj_ComicDetailPage.Navigateback(driver);
			logger.info("Navigate back to the Comic Detail page");}
		else {Assert.assertTrue(false);
		 logger.fatal("The Bugs link could not be found on the Comic Detail Page");}
		
		if(obj_ComicDetailPage.CheckTable(driver)){
			Assert.assertTrue(true);
			logger.info("The Table Link in the Comic Detail Page is Checked");;
			obj_ComicDetailPage.Navigateback(driver);
			logger.info("Navigate back to the Comic Detail page");}
		else {Assert.assertTrue(false);
		   logger.fatal("The Table link could not be found on the Comic Detail Page");}
		   logger.info("Finished executing TC_ViewDecComic");
     }
}
