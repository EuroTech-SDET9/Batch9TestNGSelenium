package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PostsPage extends BasePage{

    @FindBy(id = "post-form-title")
    public WebElement titleInput;

    @FindBy(id = "post-form-textarea")
    public WebElement postInput;

    @FindBy(css = "#post-form-btn")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Post Created']")
    public WebElement postCreatedMessage;

    public void postComment(String titleText, String postText) {
        titleInput.sendKeys(titleText);
        postInput.sendKeys(postText);
        submitButton.click();
        Assert.assertEquals(postCreatedMessage.getText(), "Post Created", "Verifying whether the post is created successfully");
    }

}
