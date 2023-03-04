package com.bw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bw.qa.base.TestBase;



public class LoginPage extends TestBase{
    //page factory
    @FindBy(id="ctl00_phBody_SignIn_txtEmail")
    WebElement username;

    @FindBy(id="ctl00_phBody_SignIn_txtPassword")
    WebElement password;

    @FindBy(id="ctl00_phBody_SignIn_btnLogin")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public String validateLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }
    public HomePage loginMultipleAccounts(String un, String pass) {
        username.sendKeys(un);
        password.sendKeys(pass);
        loginBtn.submit();
        return new HomePage();

    }



}