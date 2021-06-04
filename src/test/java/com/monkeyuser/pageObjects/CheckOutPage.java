package com.monkeyuser.pageObjects;


import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneykey.testBase.BaseClass;

public class CheckOutPage extends BaseClass {

	public CheckOutPage (){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//input[@id='checkout_email_or_phone']")
	WebElement phonenum_txt;

	@FindBy(xpath ="//input[@id='checkout_shipping_address_last_name']")
	WebElement lastname_txt;

	@FindBy(xpath= "//input[@id = 'checkout_shipping_address_address1' ]")
	WebElement address_txt;

	@FindBy(xpath = "//input[@id='checkout_shipping_address_city']")
	WebElement city_txt;

	@FindBy(xpath = "//select[@id='checkout_shipping_address_country']")
	WebElement country_drp;

	@FindBy(xpath ="//select[@id='checkout_shipping_address_province']")
	WebElement province_drp;

	@FindBy(xpath ="//input[@id='checkout_shipping_address_zip']")
	WebElement postalcode_txt;

	@FindBy(xpath = "//button[@id='continue_button']")
	WebElement continueshipping_btn;

	@FindBy (xpath = "//tr[@class ='total-line']/td[1]/span[2]")
	WebElement totalprice_txt;

	public void enterShippingDetails(String phonenumber,String lastname,String address,String city,String country,String province, String postalcode) {
		phonenum_txt.sendKeys(phonenumber);
		lastname_txt.sendKeys(lastname);
		address_txt.sendKeys(address);
		city_txt.sendKeys(city);
		country_drp.sendKeys(country);
		province_drp.sendKeys(province);
		postalcode_txt.sendKeys(postalcode);

	}

	public String getTotalPriceAtCheckOut() {
		return totalprice_txt.getText().replaceAll("\\$", "");
	}

	public void shippingClick() {
		continueshipping_btn.click();
	}

	public String getShippingPageTitle() {
		return driver.getTitle();
	}

	public void readWriteJSON() {
		JSONParser jsonParser = new JSONParser();
		try  {
			FileReader reader = new FileReader(System.getProperty("user.dir")+"\\TestData\\test.json");
			Object obj = jsonParser.parse(reader);
			JSONArray userdetails = (JSONArray) obj;
			for(int i=0;i<userdetails.size();i++) {
				JSONObject users = (JSONObject) userdetails.get(i);
				JSONObject user = (JSONObject) users.get("userDetails");
				String phonenumber = (String) user.get("phonenumber");
				String lastname = (String) user.get("lastname");
				String address = (String) user.get("address");
				String  city = (String) user.get("city");
				String  country = (String) user.get("country");
				String  province = (String) user.get("province");
				String  postalcode = (String) user.get("postalcode");
				enterShippingDetails(phonenumber,lastname,address,city,country,province,postalcode);

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}



