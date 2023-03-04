package com.bw.qa.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bw.qa.base.TestBase;
import com.bw.qa.pages.HomePage;
import com.bw.qa.pages.LoginPage;
import com.bw.qa.util.TestUtil;



public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	
}
	
	@BeforeMethod
	public void setUp()  {
		initialization();
		 loginPage = new LoginPage();

}   @Test(priority=3)
	public void cloginPageTitleTest() {
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
}
	@Test(priority=1)
	public void aloginPageUrlTest() {
		String url = loginPage.validateLoginPageUrl();
		Assert.assertEquals(url, "https://www.bookswagon.com/login");
}


	@Test(priority=2)
	    public void bloginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}