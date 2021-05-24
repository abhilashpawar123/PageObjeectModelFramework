package com.qc.pom.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class BaseClass {

	protected WebDriver driver;
	
	public void doSetup(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_v.90.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/QueueCodes/Software/Selenium/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
	@DataProvider(name="login")
	public Object[][] getLoginInvalidData(){
		
		return new Object[][] {
			new Object[] {"", ""},
			new Object[] {"", "123456"},
			new Object[] {"queuecodes@gmail.com", ""},
			new Object[] {"queuecodes@gmail", "123456"},
			new Object[] {"queuecodes@gmail.com", "12345"},
			new Object[] {"queuecodes@gmail", "12345"}
		};
	}
	
}
