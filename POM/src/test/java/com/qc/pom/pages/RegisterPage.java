package com.qc.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	Alert alt;
	String altMsg;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(className="btn")
	WebElement submit;
	
	public void enterName(String data) {
		name.clear();
		name.sendKeys(data);
	}
	
	public void enterMobile(String data) {
		mobile.clear();
		mobile.sendKeys(data);
	}
	
	public void enterEmail(String data) {
		email.clear();
		email.sendKeys(data);
	}
	
	public void enterPassword(String data) {
		password.clear();
		password.sendKeys(data);
	}
	
	public void clickOnSubmit() {
		submit.click();
		
	}
	
	public String getAlert() {
		alt = driver.switchTo().alert();
		altMsg = alt.getText();
		alt.accept();
		return altMsg;
	}
	
	public boolean doRegister(String name, String mobile, String email, String pass) {
		enterName(name);
		enterMobile(mobile);
		enterEmail(email);
		enterPassword(pass);
		clickOnSubmit();
		String actualMsg = getAlert();
		return actualMsg.equalsIgnoreCase("User registered successfully.");
	}
	
	public boolean doInvalidDataRegister(String name, String mobile, String email, String pass) {
		enterName(name);
		enterMobile(mobile);
		enterEmail(email);
		enterPassword(pass);
		clickOnSubmit();
		String actualMsg = driver.getTitle();
		return actualMsg.equalsIgnoreCase("Queue Codes | Registration Page");
	}

}
