package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestMenu {
    Login_Page loginPage = new Login_Page();
    Tasks_Module_Page tasksModulePage = new Tasks_Module_Page();
    Dashboard_Page dashboardPage = new Dashboard_Page();

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
