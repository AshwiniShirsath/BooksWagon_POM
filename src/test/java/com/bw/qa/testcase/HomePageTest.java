package com.bw.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bw.qa.base.TestBase;
import com.bw.qa.pages.HomePage;
import com.bw.qa.pages.LoginPage;


public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;


	public HomePageTest() {
	super();	
}
	@BeforeMethod
	public void setUp()  {
	initialization();
	 loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

}
	@Test(priority=1)
	public void verifyHomePageTest() {
	String homePageTitle = homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
}

	@Test(priority=2)
	public void verifyuserPersonalSettings() {
	Assert.assertTrue(homePage.verifyPersonalSettings());
}
	@Test(priority=3)
	public void verifyMyOrders() {
	Assert.assertTrue(homePage.verifyMyOrders());
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
	
}