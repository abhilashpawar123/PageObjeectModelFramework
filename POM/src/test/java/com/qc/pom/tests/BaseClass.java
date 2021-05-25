package com.qc.pom.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.qc.pom.utils.ReadData;

public class BaseClass {

	protected WebDriver driver;
	ReadData data = new ReadData();
	public void doSetup(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_v.90.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/QueueCodes/Software/Selenium/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
	@DataProvider(name="login")
	public Object[][] getLoginInvalidData() throws IOException{
		
		return data.getLoginData("Sheet1");
	}
	
	@DataProvider(name="register")
	public Object[][] getRegisterInvalidData() throws IOException{
		
		return data.getLoginData("Sheet2");
	}
	
}
