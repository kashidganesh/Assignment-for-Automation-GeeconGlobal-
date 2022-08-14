package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddDetails {
	WebDriver driver;

	public AddDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='billing_first_name\']")
	@CacheLookup
	WebElement First_Name;

	@FindBy(how = How.XPATH, using = "//input[@id=\"billing_last_name\"]")
	@CacheLookup
	WebElement Last_Name;

	@FindBy(how = How.XPATH, using = "//*[@id='billing_address_1']")
	@CacheLookup
	WebElement Address1;

	@FindBy(how = How.XPATH, using = "//*[@id='billing_address_2']")
	@CacheLookup
	WebElement Address2;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='billing_city']")
	WebElement City;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='billing_state']")
	WebElement State;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='billing_postcode']")
	WebElement Zip;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='billing_email']")
	WebElement Email;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='billing_phone']")
	WebElement Phone;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[3]/div/div/div/div/button")
	WebElement Continue;
	
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[3]/div/div/div/div/div[3]/div[1]/button")
	WebElement UseThisAddress;


	public void setFirst_Name(String first_Name) {
		First_Name.sendKeys(first_Name);
	}

	public void setLast_Name(String last_Name) {
		Last_Name.sendKeys(last_Name);
	}

	public void setAddress1(String address1) {
		Address1.sendKeys(address1);
	}

	public void setAddress2(String address2) {
		Address2.sendKeys(address2);
	}

	public void setCity(String city) {
		City.sendKeys(city);
	}

	public void setState(String state) {
		State.sendKeys(state);
	}

	public void setZip(String zip) {
		Zip.sendKeys(zip);
	}

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setPhone(String phone) {
		Phone.sendKeys(phone);
	}

	public void Continue() {
		Continue.click();
	}
	
	public void UseThisAddress() {
		UseThisAddress.click();
	}
	
	

}
