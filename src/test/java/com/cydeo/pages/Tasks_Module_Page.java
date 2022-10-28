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
    public List<WebElement> allListsMenu;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[contains(@placeholder,'task to ')]")
    public WebElement inputBoxForNewTask;

    @FindBy(xpath = "//div[@class='title']/span")
    public List<WebElement> listOfAllTasksRelatedToTheCurrentTab;

    @FindBy(xpath = "//button[@class='settings-button']")
    public WebElement settingsButton;

    @FindBy(xpath = "//select[@id='defaultCalendar']")
    public WebElement dropdownForDefaultList;

    @FindBy(id = "visibilityCollection-starred")
    public WebElement importantDropdown;

    @FindBy(id = "visibilityCollection-today")
    public WebElement todayDropdown;

    @FindBy(id = "visibilityCollection-completed")
    public WebElement completedDropdown;

    @FindBy(id = "visibilityCollection-week")
    public WebElement weekDropdown;

    @FindBy(id = "visibilityCollection-all")
    public WebElement allDropdown;

    @FindBy(id = "visibilityCollection-current")
    public WebElement currentDropdown;


    @FindBy(xpath = "//div[@class='task-checkbox']")
    public List<WebElement> allCheckBoxesFromTheCurrentList;

    @FindBy(xpath = "//span[.='1 Completed Task']")
    public WebElement oneCompletedTaskLink;

    @FindBy(xpath = "//button[@class='inline task-star reactive no-nav']/span")
    public List<WebElement> allStarIconsFromTheCurrentList;

    @FindBy (xpath = "//button[@class='icon action-item__menutoggle icon-checkmark--down']")
    public WebElement visibilityCheck;

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
