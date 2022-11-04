package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
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

    @FindBy(xpath = "//*[starts-with(@id,'list')]")
    public List<WebElement> allListOptionsButtons;

    @FindBy(xpath = "//span[.='Delete']")
    public WebElement deleteListButton;

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
    public void chooseListFromTheMenuAndClick(String ListName) {
        for (WebElement eachList : allListsMenu) {
            String eachTitleName = eachList.getAttribute("title");
            if (eachTitleName.equals(ListName)){
                eachList.click();
            }
        }
    }
    public void clickOnTheCheckBox(String taskName) {
        for (int i = 0; i < listOfAllTasksRelatedToTheCurrentTab.size(); i++) {
            WebElement task = listOfAllTasksRelatedToTheCurrentTab.get(i);
            if(task.getText().equals(taskName)){
                WebElement checkbox = allCheckBoxesFromTheCurrentList.get(i);
                checkbox.click();
                return;
            }
        }
    }
    public void clickOnTheStarIcon(String taskName) {
        for (int i = 0; i < listOfAllTasksRelatedToTheCurrentTab.size(); i++) {
            WebElement task = listOfAllTasksRelatedToTheCurrentTab.get(i);
            if(task.getText().equals(taskName)){
                WebElement starIcon = allStarIconsFromTheCurrentList.get(i);
                starIcon.click();
                Assert.assertTrue(starIcon.getAttribute("class").contains("color"));
                break;
            }
        }
    }
    public void deleteListFromMenu(String listName){
        chooseListFromTheMenuAndClick(listName);
        listName = listName.replace(". ","-").replace("! ","-").replace(", ","-").replace(" ","-").toLowerCase();
        for (WebElement eachListButton : allListOptionsButtons) {
            if(eachListButton.getAttribute("id").equals("list_"+listName)){
                String buttonLocator = "//*[@id='list_" + listName + "']/div/div/div/div/button";
                WebElement button = Driver.getDriver().findElement(By.xpath(buttonLocator));
                button.click();
                //BrowserUtils.waitFor(5);
                deleteListButton.click();
            }
        }
    }
    public void checkIfTaskContainsUnderTheCurrentList(String taskName){
        //List<WebElement> allTasksFromTheList = listOfAllTasksRelatedToTheCurrentTab;
        for (int i = 0; i < listOfAllTasksRelatedToTheCurrentTab.size(); i++) {
            WebElement task = listOfAllTasksRelatedToTheCurrentTab.get(i);
            if(task.getText().equals(taskName)){
                Assert.assertTrue(task.isDisplayed());
                return;
            }
        }
    }
    public void deleteAllListsFromTheMenu(){
        String list1="9";
        String list2="Ne";
        String list3="New Task";
        String list4="The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt";
        for (WebElement eachList : allListsMenu) {
            if (eachList.getText().equals(list1) || eachList.getText().equals(list2) || eachList.getText().equals(list3)) {
                eachList.click();
                //List<WebElement> allCheckBoxesFromTheList = allCheckBoxesFromTheCurrentList;
                try{
                    allCheckBoxesFromTheCurrentList.get(0).click();
                }catch (RuntimeException e){
                    continue;
                }

            }
        }
        deleteListFromMenu(list1);
        deleteListFromMenu(list2);
        deleteListFromMenu(list3);
        deleteListFromMenu(list4);

    }

}
