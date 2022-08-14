package com.PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SubmitDetails {
	private static final Logger log = Logger.getLogger(SubmitDetails.class);
	WebDriver driver;

	public SubmitDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Submit_Donation() throws InterruptedException, AWTException {
		try {
			Robot robot = new Robot();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			log.info("Enter Submit Button");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	
		
	}

}
