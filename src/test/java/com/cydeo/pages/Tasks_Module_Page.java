package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Tasks_Module_Page {

    public Tasks_Module_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@title='Add List…']")
    public WebElement addListButton;

    @FindBy(id="newListInput")
    public WebElement newListInputBox;

    @FindBy(xpath = "//form//input[@title='Save']")
    public List<WebElement> saveTaskButtons;

    @FindBy(xpath = "//form//input[@title='Cancel']")
    public List<WebElement> cancelTaskButtons;

    @FindBy(xpath = "//div[@class='colorpicker']")
    public List<WebElement> colorPickers;

    @FindBy(xpath = "//a/span[@class='app-navigation-entry__title']")
    public List<WebElement>  allListsMenu;

    public ArrayList<String> check_if_new_list_appearsInThe_menu(){
        ArrayList<String> allListsTitles=new ArrayList<>();
        for (WebElement eachList : allListsMenu) {
            String eachTitleName = eachList.getAttribute("title");
            allListsTitles.add(eachTitleName);
        }
       return allListsTitles;
    }

    public void clickOnSaveListButton() {
        int indexOfLastSaveButton = saveTaskButtons.size() - 1;
        saveTaskButtons.get(indexOfLastSaveButton).click();
    }
    public void clickOnCancelListButton() {
        int indexOfLastCancelButton = cancelTaskButtons.size() - 1;
        cancelTaskButtons.get(indexOfLastCancelButton).click();
    }





}
