package org.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;
import org.testng.Assert;

public class LoginStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the application login page")
    public void i_am_on_the_application_login_page() {
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() {
        loginPage.enterEmail("standard_user");
        loginPage.enterPassword("secret_sauce");
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.cilickLogin();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        boolean success = loginPage.validateSuccessfulLogin();
        Assert.assertTrue(success);
    }

    @Given("I have enetered invalid {string} and {string}")
    public void iHaveEneteredInvalidAnd(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMsg) {
        boolean success = loginPage.validateErrorMsg(errorMsg);
        Assert.assertTrue(success);
    }
}
