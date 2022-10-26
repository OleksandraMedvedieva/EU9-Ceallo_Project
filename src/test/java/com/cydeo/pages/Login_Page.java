package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement userNameOrEmailInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("cealloURl"));
        userNameOrEmailInputBox.sendKeys("Employee31");
        passwordInputBox.sendKeys("Employee123");
        loginButton.click();
    }


}
