package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {


    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement nameOnProfileMenu;

    @FindBy(linkText = "Logout")
    public WebElement logout;

}
