package com.qc.pom.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qc.pom.pages.HomePage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseClass {

	@BeforeSuite
	public void launching() {
		doSetup();
	}

	@Test(dataProvider = "login", priority = 0)
	public void loginWithInvalid(String uName, String uPass) {

		LoginPage login = new LoginPage(driver);

		boolean result = login.doLoginWithInvalid(uName, uPass);

		assertTrue(result);
	}
	
	@Test(priority = 1)
	public void loginTest() {
		LoginPage login = new LoginPage(driver);

		HomePage home = login.doLogin("queuecodes@gmail.com", "123456");

		assertTrue(home.homeTitleAssertion());

		home.doLogout();
	}

	@Test(priority = 2, dataProvider = "register")
	public void registerWithInvalidTest(String uName, String uMobile, String uEmail, String uPass) {
		String title= driver.getTitle();
		if(title.equals("Queue Codes | Log in")) {
			goToRegister();
		}
		RegisterPage register = new RegisterPage(driver);

		boolean result = register.doInvalidDataRegister(uName, uMobile, uEmail, uPass);

		assertTrue(result);
	}

	@Test(priority = 3)
	public void registerTest() {
		RegisterPage register = new RegisterPage(driver);

		boolean result = register.doRegister("Queue", "9145425494", "queue@gmail.com", "12345");

		assertTrue(result);
	}
	public void goToRegister() {
		driver.findElement(By.linkText("Register a new membership")).click();
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}
