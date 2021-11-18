package com.navfort.step_definitions;


import com.navfort.pages.DashboardPage;
import com.navfort.pages.LoginPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       String url=ConfigurationReader.get("url");
       Driver.get().get(url);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        new LoginPage().login(username,password);


    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {

        BrowserUtils.waitFor(2);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> loginCredentials) {
       LoginPage loginPage = new LoginPage();
       loginPage.login(loginCredentials.get("username"),loginCredentials.get("password"));
    }

    @Then("the user should see the name")
    public void the_user_should_see_the_name() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(new DashboardPage().nameOnProfileMenu.isDisplayed());
    }


    @Then("the user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String expectedMessage) {
        String actualMessage = new LoginPage().errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("the user clicks on {string} link")
    public void theUserClicksOnLink(String expectedLink) {
        new LoginPage().forgotPasswordLink.click();
    }

    @And("the user should see the link {string}")
    public void theUserShouldSeeTheLink(String expectedLink) {
        Assert.assertEquals(expectedLink, new LoginPage().rememberMeLink.getText());
    }

    @And("the link should be clickable")
    public void theLinkShouldBeClickable() {
        Assert.assertTrue(new LoginPage().rememberMeCheckBox.isEnabled());
    }

    @And("user can use enter key from their keyboard on the login page")
    public void userCanUseEnterKeyFromTheirKeyboardOnTheLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys( "User1",Keys.ENTER);
        loginPage.password.sendKeys("UserUser123",Keys.ENTER);

    }

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {

        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));

        //based on input enter that user information
        String username="null";
        String password="null";

        if(userType.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")){
            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");
        }else if (userType.contains("store manager")){
            username=ConfigurationReader.get("store_manager_username");
            password=ConfigurationReader.get("store_manager_password");
        }

        //send information to login
        new LoginPage().login(username, password);
    }


    @Then("the user should see {string}")
    public void theUserShouldSee(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @And("the user should see the password as a bullet sign")
    public void theUserShouldSeeThePasswordAsABulletSign() {

        if(Driver.get().findElement(By.xpath("//input[@type='password']"))!= null){
            System.out.println("Bullet signs are present");
        }else{
            System.out.println("Bullet signs are absent");
        }
    }
}
