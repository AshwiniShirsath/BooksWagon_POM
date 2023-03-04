package com.bw.qa.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bw.qa.base.TestBase;
import com.bw.qa.pages.LoginPage;
import com.bw.qa.pages.WishListPage;

public class WishListPageTest extends TestBase {
	LoginPage loginPage;
	WishListPage wishlist;
	Logger log = Logger.getLogger(WishListPageTest.class);

	public WishListPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(" Starting test cases execution  ");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		wishlist = new WishListPage();
	}

	@Test(priority = 1)
	public void feature_authTest() throws InterruptedException {
		log.info("Feature Author Method Running...");
		wishlist.feature_auth();
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "Buy Best Selling Arundhati Roy Books Online at Bookswagon");
		System.out.println("title:" + title);
	}

	@Test(priority = 2)
	public void search_BookNameTest() throws InterruptedException {
		log.info("Search by book name Method Running...");
		wishlist.search_BookName(prop.getProperty("ArundhatiRoyByBookname"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "god of small things - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:" + title);
	}

	@Test(priority = 3)
	public void addWishlist_AuthorNameTest() throws InterruptedException {
		log.info("Search by Author name Method Running...");
		wishlist.addWishlist_AuthorName(prop.getProperty("ArundhatiRoyByAuthor"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "arundhati roy - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:" + title);
	}

	@Test(priority = 4)
	public void addWishlist_PublisherTest() throws InterruptedException {
		log.info("Search by Publisher Method Running...");
		wishlist.addWishlist_Publisher(prop.getProperty("ArundhatiRoyByPublisher"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "penguin books india pvt ltd - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:" + title);
	}

	@Test(priority = 5)
	public void wishlist_Test() throws InterruptedException {
		log.info("Wishlist Method Running...");
		wishlist.wish_list();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}

}