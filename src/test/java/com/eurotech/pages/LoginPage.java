package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {





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





    //@FindAll
    //To use multiple locator if at least one of them is matching it will find the web element.
    @FindAll({
            @FindBy(id = "loginpage-input-email"), //or
            @FindBy(name = "emailhghjghjghghghjgjh")})
    public WebElement usernameInputFindAll;

    //@FindBys
    //if the locators are matching with the element then it will return it.
    @FindBys({
            @FindBy(id = "loginpage-form-pw-input"),   // and
            @FindBy(name = "password")
    })
    public WebElement passwordInputFindBys;



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
