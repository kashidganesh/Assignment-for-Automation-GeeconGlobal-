package com.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FirstPage {

	WebDriver driver;

	public FirstPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "gender")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "age")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//*[@id='main']/div[1]/div/div[2]/a")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//div[@class='card__wrapper child-tile child-index-1 ']")
	@CacheLookup
	WebElement ClickOnPhoto;

	@FindBy(xpath = "//a[@class='child-tile-cta btn btn-primary cta-link']")
	@CacheLookup
	WebElement ClickOnSponsorMe;

	@FindBy(xpath = "//*[@id='post-5']/div/div/div/div[3]/div/div[3]/div[1]/a")
	@CacheLookup
	WebElement ClickOnBeginCheckout;

	@FindBy(xpath = "//a[@id=\"checkout-guest-continue\"]")
	@CacheLookup
	WebElement ContinueAsGuest;

	public void BeginCheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		ClickOnBeginCheckout.click();
	}

	public void setGender(String uname) {
		Select s = new Select(txtUserName);
		s.selectByValue(uname);
	}

	public void setAge(String pwd) {
		Select s = new Select(txtPassword);
		s.selectByValue(pwd);
	}

	public void clickSubmit() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		btnLogin.click();
	}

	public void clickOnImg() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		ClickOnPhoto.click();
	}

	public void SponsorMe() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		ClickOnSponsorMe.click();
		Thread.sleep(5000);
	}

	public void ContinueAsGuest() throws InterruptedException {
		ContinueAsGuest.click();
		Thread.sleep(5000);
	}

	// /////////////////////////////////////////////////

	@FindBy(how = How.XPATH, using = "//*[@id='billing_first_name\']")
	@CacheLookup
	WebElement First_Name;

	@FindBy(how = How.XPATH, using = "//*[@id='billing_last_name']")
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

	public void setFirst_Name(String first_Name) {
		First_Name.sendKeys(first_Name);
	}

	public void setLast_Name(String last_Name) {
		Last_Name.sendKeys();
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

}
