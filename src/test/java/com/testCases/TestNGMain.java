package com.testCases;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;

public class TestNGMain {
	public static void main(String[] args) {
		String log4jConfPath = "Configuration/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		TestNG testng = new TestNG();
		List<String> suitefiles = new ArrayList<String>();
		suitefiles.add("testng.xml");
		testng.setTestSuites(suitefiles);
		testng.run();		
	}

}
