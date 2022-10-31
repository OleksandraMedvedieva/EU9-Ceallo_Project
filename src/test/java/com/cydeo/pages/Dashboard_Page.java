package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard_Page {

    public Dashboard_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@tabindex='-1']")
    public List<WebElement> appMenu;

    @FindBy(xpath = "//a[@aria-label='Tasks']")
    public WebElement taskModule;

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement userIconButton;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement currentUserStatus;

    @FindBy(xpath = "//label[contains(@class,'user-status')]")
    public List<WebElement> allUserStatuses;

    @FindBy(xpath = "//button[@class='action-item action-item--single header-close icon-close undefined undefined has-tooltip']")
    public WebElement close;



}
