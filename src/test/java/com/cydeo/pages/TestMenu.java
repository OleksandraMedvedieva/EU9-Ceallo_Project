package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMenu {
    Login_Page loginPage = new Login_Page();
    Tasks_Module_Page tasksModulePage = new Tasks_Module_Page();
    Dashboard_Page dashboardPage = new Dashboard_Page();
    Faker faker = new Faker();

    @Test
    public void testAfter() throws InterruptedException {
        loginPage.login();
        dashboardPage.taskModule.click();
        Thread.sleep(3000);
        String list1="9";
        String list2="Ne";
        String list3="New Task";
        String list4="The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt";
        for (WebElement eachList : tasksModulePage.allListsMenu) {
            if (eachList.getText().equals(list1) || eachList.getText().equals(list2) || eachList.getText().equals(list3)) {
                eachList.click();
                List<WebElement> allCheckBoxesFromTheList = tasksModulePage.allCheckBoxesFromTheCurrentList;
                allCheckBoxesFromTheList.get(0).click();
            }
        }

        tasksModulePage.deleteListFromMenu(list1);
        tasksModulePage.deleteListFromMenu(list2);
        tasksModulePage.deleteListFromMenu(list3);
        tasksModulePage.deleteListFromMenu(list4);











    }

    @Test
    public void status() throws InterruptedException {
        loginPage.login();
        dashboardPage.userIconButton.click();
        dashboardPage.currentUserStatus.click();
        List<WebElement> allStatusList = dashboardPage.allUserStatuses;
        for (WebElement eachstatus : allStatusList) {
            if (eachstatus.getText().equals("Online")){
                eachstatus.click();
                Thread.sleep(5000);

            }
        }
        Thread.sleep(5000);
        dashboardPage.close.click();
        dashboardPage.userIconButton.click();
        System.out.println("dashboardPage.currentUserStatus.getText() = " + dashboardPage.currentUserStatus.getText());

        for (WebElement eachstatus : allStatusList) {
            if (eachstatus.getText().equals("Away")){
                eachstatus.click();
                Thread.sleep(5000);

            }
        }
        Thread.sleep(5000);
        dashboardPage.close.click();
        dashboardPage.userIconButton.click();
        System.out.println("dashboardPage.currentUserStatus.getText() = " + dashboardPage.currentUserStatus.getText());


    }

    @Test
    public void checkboxes() throws InterruptedException {
        loginPage.login();
        dashboardPage.taskModule.click();
        Thread.sleep(3000);
        for (WebElement eachList : tasksModulePage.allListsMenu) {
            if(eachList.getText().equals("Ne")){
                System.out.println("eachList.getText() = " + eachList.getText());
                eachList.click();
            }
        }

        List<WebElement> allTasks = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
            System.out.println("allTasks = " + allTasks.size());

    }









    @Test
    public void listName() throws InterruptedException {
        loginPage.login();
        dashboardPage.taskModule.click();
        tasksModulePage.settingsButton.click();
        //tasksModulePage.dropdownForDefaultList.click();
        Select select = new Select(tasksModulePage.dropdownForDefaultList);
        select.selectByVisibleText("Love");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        for (WebElement eachList : tasksModulePage.allListsMenu) {
            String eachTitleName = eachList.getAttribute("title");
            //System.out.println("eachTitleName = " + eachTitleName);
            if (eachTitleName.equals("All")){
                    eachList.click();
                }
        }
        //System.out.println("HI");
        tasksModulePage.inputBoxForNewTask.click();
        //System.out.println("there");
        tasksModulePage.inputBoxForNewTask.sendKeys("Sasha Task" + Keys.ENTER);

        for (WebElement eachTask : tasksModulePage.listOfAllTasksRelatedToTheCurrentTab) {
            System.out.println("eachTask.getText() = " + eachTask.getText());
        }



    }

    @Test
    public void errorMessage() throws InterruptedException {
        loginPage.login();
        dashboardPage.taskModule.click();
        tasksModulePage.addListButton.click();
        tasksModulePage.newListInputBox.sendKeys("New Task");
        Thread.sleep(2000);
        tasksModulePage.clickOnSaveListButton();
        String actualErrorMessage = tasksModulePage.errorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
    }


    @Test
    public void appMenu() throws InterruptedException {
        loginPage.login();
        String moduleName = "Tasks";
        Thread.sleep(2000);
        //List<WebElement> appMenu = Driver.getDriver().findElements(By.xpath("//ul[@id='appmenu']/li/a"));
       WebElement a = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li/a"));
 }
    @Test
    public void saveButtonTest() {
        loginPage.login();
        dashboardPage.taskModule.click();
        tasksModulePage.addListButton.click();
        tasksModulePage.newListInputBox.sendKeys("Sasha123");
        //tasksModulePage.chooseColor(5);
        List<WebElement> saveNewTaskButton = Driver.getDriver().findElements(By.xpath("//form//input[@title='Save']"));
        int lastIndex = saveNewTaskButton.size() - 1;
        saveNewTaskButton.get(lastIndex).click();
    }



}
