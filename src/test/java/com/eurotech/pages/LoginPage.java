package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(id = "loginpage-input-email")
    public WebElement usernameInput;

    @FindBy(css = "#loginpage-form-pw-input")
    public WebElement passwordInput;

    @FindBy(id = "loginpage-form-btn")
    public WebElement loginBtn;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;

    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    public WebElement forgotPasswordBtn;

    @FindBy(xpath = "//*[text()='Invalid Credentials!']")
    public WebElement warningMessage;



    public void login(String username,String password){
        understandBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginWithStudent(){
        understandBtn.click();
        usernameInput.sendKeys(ConfigurationReader.get("usernameStudent"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordStudent"));
        loginBtn.click();

    }
    public void loginWithTeacher(){
        understandBtn.click();
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginBtn.click();
    }
}
