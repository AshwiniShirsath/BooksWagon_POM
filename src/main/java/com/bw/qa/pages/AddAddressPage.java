package com.bw.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bw.qa.base.TestBase;


public class AddAddressPage extends TestBase{

    @FindBy(xpath ="//a[normalize-space()='My Addresses']")
    WebElement my_address;

    @FindBy(xpath ="//input[@value='Add a New Address']")
    WebElement add_new_address;


    @FindBy(xpath ="//input[@id='ctl00_phBody_ShippingAddress_txtRecipientName']")
    WebElement recipient_name;

    @FindBy(xpath ="//textarea[@id='ctl00_phBody_ShippingAddress_txtAddress']")
    WebElement street_address;

    @FindBy(xpath="//select[@id='ctl00_phBody_ShippingAddress_ddlCountry']")
    WebElement country;

    @FindBy(xpath="//select[@id='ctl00_phBody_ShippingAddress_ddlState']")
    WebElement state;

    @FindBy(xpath="//select[@id='ctl00_phBody_ShippingAddress_ddlCities']")
    WebElement city;

    @FindBy(xpath="//input[@id='ctl00_phBody_ShippingAddress_txtPincode']")
    WebElement pincode;

    @FindBy(xpath="//input[@id='ctl00_phBody_ShippingAddress_txtMobile']")
    WebElement mobile;

    @FindBy(xpath="//input[@id='ctl00_phBody_ShippingAddress_imgSubmit']")
    WebElement save;

    public AddAddressPage() {
        PageFactory.initElements(driver, this);
    }

    public void add_Address(String RecipientName, String StreetAddress, String Country, String State, String City, String PinCode, String Mobile)
            throws AWTException {
        my_address.click();
        add_new_address.click();
        recipient_name.sendKeys(RecipientName);
        street_address.sendKeys(StreetAddress);
        Select c = new Select(country);
        c.selectByVisibleText(Country);
        Robot robot = new Robot();
        robot.mouseWheel(1);
        Select s = new Select(state);
        s.selectByVisibleText(State);
        Select ct = new Select(city);
        ct.selectByVisibleText(City);

        pincode.sendKeys(PinCode);
        mobile.sendKeys(Mobile);

    }
}