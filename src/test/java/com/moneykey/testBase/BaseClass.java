package com.moneykey.testBase;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static WebDriver driver;
	public static Logger logger; //Log4j Logging
	public ResourceBundle rb; //to read config.properties
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) {
		//Load config.properties
				rb= ResourceBundle.getBundle("config"); 
				//Log4j Logging
				logger = LogManager.getLogger(this.getClass());
				if(br.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", rb.getString("chromepath"));
					driver = new ChromeDriver();
					logger.info("Launched Chrome Browser");
				}
				else if(br.equals("firefox"))
				{	
					System.setProperty("webdriver.chrome.driver", rb.getString("firefoxpath"));
					driver = new ChromeDriver();
					logger.info("Launched Firefox Browser");
				}
				driver.get(rb.getString("URL"));
				driver.manage().window().maximize();
	}


	@AfterClass
	public void closebrowser()
	{
		driver.quit();
		
	}
	
}
