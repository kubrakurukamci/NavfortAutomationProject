package com.navfort.step_definitions;

import com.navfort.pages.DashboardPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class LogoutStepDefs {

    @Then("the user can log out by using log out button inside profile info")
    public void theUserCanLogOutByUsingLogOutButtonInsideProfileInfo() {
        BrowserUtils.waitFor(5);
        new DashboardPage().nameOnProfileMenu.click();
        new WebDriverWait(Driver.get(),20).until(ExpectedConditions.elementToBeClickable(new  DashboardPage().logout));
        new DashboardPage().logout.click();
        BrowserUtils.waitFor(2);

    }

    @And("the user ends up in login page.")
    public void theUserEndsUpInLoginPage() {
        Assert.assertEquals("https://qa.navfort.com/user/login", Driver.get().getCurrentUrl());
    }


    @Then("the user tries to  go to the home page again by clicking the step back button after successfully logged out")
    public void theUserTriesToGoToTheHomePageAgainByClickingTheStepBackButtonAfterSuccessfullyLoggedOut() {
        Driver.get().navigate().back();
        Driver.get().navigate().forward();
    }

    @And("the user closes the tab")
    public void theUserClosesTheTab() {
        Driver.get().close();
        Driver.closeDriver();



    }

    @When("the user waits for {int} minutes")
    public void theUserWaitsForMinutes(int minutes) {
        BrowserUtils.waitFor(300);
    }

    @Then("the user is again on the login page")
    public void theUserIsAgainOnTheLoginPage() {

        Driver.get().get("https://qa.navfort.com/");
        Assert.assertEquals("https://qa.navfort.com/user/login", Driver.get().getCurrentUrl());
        System.out.println(Driver.get().getCurrentUrl());


    }

}
