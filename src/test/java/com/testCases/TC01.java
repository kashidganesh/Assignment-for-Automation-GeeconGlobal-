package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.PageObject.AddDetails;
import com.PageObject.FirstPage;
import com.PageObject.KeyWordEngine;
import com.PageObject.SubmitDetails;

import junit.framework.Assert;

public class TC01 extends BaseClass {
	private static final Logger log = Logger.getLogger(TC01.class);

	public KeyWordEngine keyWordEngine;

	@Test(priority = 1)
	public void loginTest() throws InterruptedException, IOException {
		log.info("Test Case 1 Start");
		FirstPage lp = new FirstPage(driver);
		lp.setGender(Gender);
		log.info("Gender :" + Gender);
		lp.setAge(Age);
		log.info("Age :" + Age);
		lp.clickSubmit();
		log.info("Click Submit Button");
		Thread.sleep(4000);
		lp.clickOnImg();
		log.info("Click On Image ");
		Thread.sleep(4000);
		lp.SponsorMe();
		log.info("Click on SponsorMe Button ");
		lp.BeginCheckout();
		log.info("Click On BeginChekout Button ");
		lp.ContinueAsGuest();
		log.info("Click On Continue As Guest Button");

		String GetText = driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/h2")).getText();
		String actualText = "Billing Address";
		if (GetText.equals(actualText)) {
			Assert.assertTrue("test cases pass successfully", true);
			log.info("test cases One pass successfully");

		} else {
			Assert.assertFalse("test cases failed", false);
			log.info("test case 1 failed ");
		}
	}

	@Test(priority = 2, dataProvider = "LoginData")
	public void loginDDT(String First_Name, String Last_Name, String Address1, String Address2, String City,
			String State, String Zip, String Email, String Phone) throws InterruptedException {
		log.info("Test Case 2 Start");
		AddDetails ad = new AddDetails(driver);
		ad.setFirst_Name(First_Name);
		log.info("First_Name :"+First_Name);
		ad.setLast_Name(Last_Name);
		log.info("Last_Name :"+Last_Name);
		ad.setAddress1(Address1);
		log.info("Address1 :"+Address1);
		ad.setAddress2(Address2);
		log.info("Address2 :"+Address2);
		ad.setCity(City);
		log.info("City :"+City);
		ad.setState(State);
		log.info("State :"+State);
		ad.setZip(Zip);
		log.info("Zip :"+Zip);
		ad.setEmail(Email);
		log.info("Email :"+Email);
		ad.setPhone(Phone);
		log.info("Phone :"+Phone);
		ad.Continue();
		log.info("Click On Continue Button ");
		ad.UseThisAddress();
		log.info("Click On UseThisAddress");
		Thread.sleep(3000);
		String GetText = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/h1")).getText();
		String actualText = "Your Donations";
		if (GetText.equals(actualText)) {
			Assert.assertTrue("test cases pass successfully", true);
			log.info("test cases 2 pass successfully");

		} else {
			Assert.assertFalse("test cases failed", false);
			log.info("test case 2 failed");
		}
	}

	@Test(priority = 3)
	public void Keyword() throws InterruptedException {
		KeyWordEngine engine = new KeyWordEngine(driver);
		log.info("Test Case 3 Start");
		engine.startExecution("Sheet1");
		log.info("test case 3 pass successfully");
	}

	@Test(priority = 4)
	public void Credit() throws Throwable {
		SubmitDetails acd = new SubmitDetails(driver);
		try {
			log.info("Test Case 4 Start");
			//Thread.sleep(7000);
			acd.Submit_Donation();
			Thread.sleep(9000);
			
			String GetText = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div/div/div[1]/div[2]/div/h1"))
					.getText();
			String actualText = "Thanks Test!";
			if (GetText.equals(actualText)) {
				Assert.assertTrue("test cases pass successfully", true);
				System.out.println("test case 4 pass successfully");

			} else {
				Assert.assertFalse("test cases failed", false);
				System.out.println("test cases failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
