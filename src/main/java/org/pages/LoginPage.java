package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //by locators
    private By emailBox = By.xpath("//input[@id='user-name']");
    private By passwordBox = By.xpath("//input[@id='password']");
    private By loginBtn = By.xpath("//input[@id='login-button']");
    private By errorMsg = By.xpath("//div[@class='error-message-container error']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //page methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailBox);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String pass){
        WebElement passInput = driver.findElement(passwordBox);
        passInput.sendKeys(pass);
    }
    public void cilickLogin(){
        WebElement login = driver.findElement(loginBtn);
        login.click();
    }
    public boolean validateErrorMsg(String message){
        WebElement error = driver.findElement(errorMsg);
        return error.getText().equals(message);
    }
    public boolean validateSuccessfulLogin(){
        String title = driver.getTitle();
        return title.equals("Swag Labs");
    }
}
