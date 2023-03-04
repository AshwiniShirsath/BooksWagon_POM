package com.bw.qa.testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bw.qa.base.TestBase;
import com.bw.qa.pages.HomePage;
import com.bw.qa.pages.LoginPage;
import com.bw.qa.pages.SearchBookPage;

public class SearchBookPageTest extends TestBase {
	SearchBookPage searchBook;
	HomePage homePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(SearchBookPageTest.class);
	
	public SearchBookPageTest () {
		super();
	}

	@BeforeMethod()
	public void setUp() throws IOException, InterruptedException {
		log.info("Starting test cases execution");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchBook = new SearchBookPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifySearchPageTest() throws Exception{
		searchBook.clickSearchButton("Ashwini");
		searchBook.clickOnBookNow();
		
	}
	
	@Test(priority = 2)
	public void validateSearchPageTitle() {
		String title = searchBook.validateSearchPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		System.out.println("title:"+title);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

		
	}
}