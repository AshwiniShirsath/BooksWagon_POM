package com.bw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bw.qa.base.TestBase;

public class WishListPage extends TestBase{
	
	@FindBy(xpath = "//li[@id='ctl00_liRequestBook']//a[normalize-space()='Featured Authors']")
	WebElement fea_Auth;

	@FindBy(xpath = "//a[normalize-space()='Arundhati Roy']")
	WebElement auth_name;

	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]")
	WebElement add_wish;

	@FindBy(xpath = "//a[text()='My Wishlist']")
	WebElement wish_List;

	@FindBy(xpath = "//input[@id='inputbar']")
	WebElement search_bar;

	@FindBy(xpath = "//input[@id='btnTopSearch']")
	WebElement search_icon;

	public WishListPage() {
	PageFactory.initElements(driver, this);
	}

	public String validateWishListPageTitle(){
	return driver.getTitle();
	}

	public void feature_auth() throws InterruptedException {
	fea_Auth.click();
	Thread.sleep(2000);
	auth_name.click();
	Thread.sleep(2000);
	add_wish.click();
	Thread.sleep(2000);
	this.validateWishListPageTitle();
	}

	public void search_BookName(String book) throws InterruptedException {
	search_bar.sendKeys(book);
	Thread.sleep(2000);
	search_icon.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]"))
	.click();
	this.validateWishListPageTitle();
	}

	public void addWishlist_AuthorName(String author) throws InterruptedException {
	Thread.sleep(2000);
	search_bar.sendKeys(author);
	Thread.sleep(2000);
	search_icon.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(
	"//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]"))
	.click();
	this.validateWishListPageTitle();
	}

	public void addWishlist_Publisher(String publisher) throws InterruptedException {
	search_bar.sendKeys(publisher);
	Thread.sleep(2000);
	search_icon.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(
	"//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]"))
	.click();
	this.validateWishListPageTitle();
	}

	public void wish_list() throws InterruptedException {
	wish_List.click();
	Thread.sleep(2000);

	}

}
