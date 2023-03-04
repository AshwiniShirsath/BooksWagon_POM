package com.bw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bw.qa.base.TestBase;

public class SearchBookPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='inputbar']")
	private WebElement searchBook;

	@FindBy(xpath = "//input[@id='btnTopSearch']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@value ='Buy Now']")
	private WebElement clickOnBookNow;

	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	private WebElement clickOnPlaceOrder;

	// initialize Object
	public SearchBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Check search box with book item
		public void SearchBookItem(String strBookName) {
			searchBook.sendKeys(strBookName);
		}
		
		// method check search button
		public void SearchBtn() {
			searchBtn.click();
		}
		
		public String validateSearchPageTitle(){
			return driver.getTitle();
		}
		

		// method to set search 
		public HomePage clickSearchButton(String strSearchBookName) throws InterruptedException {
			this.SearchBookItem(strSearchBookName);
			Thread.sleep(3000);
			this.SearchBtn();
			Thread.sleep(3000);
			return new HomePage();
		}

		// method to click on navigation book
		public void clickOnBookNow() throws InterruptedException {
			clickOnBookNow.click();
			Thread.sleep(3000);
		}
}
