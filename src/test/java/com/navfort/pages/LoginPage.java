package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(id="prependedInput")
    public WebElement userName;



    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']//div")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMeLink;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }
}
