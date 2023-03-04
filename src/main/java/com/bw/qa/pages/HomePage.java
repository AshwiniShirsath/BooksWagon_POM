package com.bw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bw.qa.base.TestBase;


public class HomePage extends TestBase {
    @FindBy(linkText="Personal Settings")
    WebElement personalSettings;


    @FindBy(linkText ="My Orders")
    WebElement myOrders;



    //Initializing the page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyPersonalSettings() {
        return personalSettings.isDisplayed();
    }

    public boolean verifyMyOrders() {
        return myOrders.isDisplayed();
    }
}