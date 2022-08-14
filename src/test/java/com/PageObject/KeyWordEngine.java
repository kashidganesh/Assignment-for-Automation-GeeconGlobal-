package com.PageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testCases.BaseClass;

public class KeyWordEngine extends BaseClass {
	private static final Logger log = Logger.getLogger(KeyWordEngine.class);
	public KeyWordEngine(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver driver;
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;
	public BaseClass base;
	public final String SCENARIO_SHEET_PATH =  System.getProperty("user.dir") + "/src/test/java/com/testData/Credit_Card_Details.xlsx";
	              
	public void startExecution(String sheetName) throws InterruptedException {

		try {

			String locatorName = null;
			String locatorValue = null;
			FileInputStream file = null;
			try {
				file = new FileInputStream(SCENARIO_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			log.info("Sheet Name :"+sheet);

			int k = 0;
			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				String locatorColValue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				log.info("locatorColValue :"+locatorColValue);
				

				if (!locatorColValue.equalsIgnoreCase("NA")) {
					locatorName = locatorColValue.split("==")[0].trim();
					log.info("locatorName :"+locatorName);
					locatorValue = locatorColValue.split("==")[1].trim();
					log.info("locatorValue :"+locatorValue);
				}
				String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				log.info("action :"+action);
				String v = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
				String value = v.replace("/", "");
				log.info("value :"+value);

				switch (locatorName) {
				case "xpath":
					try {

						WebElement element = driver.findElement(By.xpath(locatorValue));
						log.info("element :"+element);
						if (action.equalsIgnoreCase("sendkeys")) {
							element.sendKeys(value);
						}

						if (action.equalsIgnoreCase("switchframe")) {
							driver.switchTo().frame("tx_iframe_wvus_new_cc_iframe");
						}

						if (locatorValue.contains("cardNumber")) {
							element.sendKeys(Keys.TAB);
							Thread.sleep(5000);
							element.sendKeys(Keys.TAB);
							//element.sendKeys(Keys.TAB);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
