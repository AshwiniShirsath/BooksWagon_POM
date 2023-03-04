package com.bw.qa.testcase;

import java.awt.AWTException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bw.qa.base.TestBase;
import com.bw.qa.pages.AddAddressPage;
import com.bw.qa.pages.HomePage;
import com.bw.qa.pages.LoginPage;
import com.bw.qa.util.TestUtil;

public class AddAddressTest extends TestBase{
	LoginPage loginPage;
	AddAddressPage AddAddress;
	TestUtil util;
	
	public String SheetName = "Sheet1";
	
	public AddAddressTest() {
	super();	
}
	
	@BeforeMethod
	public void setUp()  {
	initialization();
	 loginPage = new LoginPage();
	 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 AddAddress = new AddAddressPage();

}
	@DataProvider
	public Object[][] getLoginTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider= "getLoginTestData")
	public void AddAddress(String RecipientName, String StreetAddress, String Country, String State, String City, String PinCode, String Mobile)
	throws AWTException {
		AddAddress.add_Address(RecipientName, StreetAddress, Country, State, City, PinCode, Mobile);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser is closed");
}

}