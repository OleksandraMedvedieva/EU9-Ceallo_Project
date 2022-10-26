package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestMenu {
    Login_Page loginPage = new Login_Page();
    Tasks_Module_Page tasksModulePage = new Tasks_Module_Page();
    Dashboard_Page dashboardPage = new Dashboard_Page();
    @Test
    public void appMenu() throws InterruptedException {
        loginPage.login();
        String moduleName = "Tasks";
        Thread.sleep(2000);
        //List<WebElement> appMenu = Driver.getDriver().findElements(By.xpath("//ul[@id='appmenu']/li/a"));
       WebElement a = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li/a"));
 }
    @Test
    public void saveButtonTet() {
        loginPage.login();
        dashboardPage.taskModule.click();
        tasksModulePage.addListButton.click();
        tasksModulePage.newListInputBox.sendKeys("Sasha123");
        //tasksModulePage.chooseColor(5);
        List<WebElement> saveNewTaskButton = Driver.getDriver().findElements(By.xpath("//form//input[@title='Save']"));
        int lastIndex = saveNewTaskButton.size() - 1;
        saveNewTaskButton.get(lastIndex).click();
    }

    @Test
    public void selectColorOnColorPicker(){
        loginPage.login();
        dashboardPage.taskModule.click();
        tasksModulePage.addListButton.click();
        tasksModulePage.newListInputBox.sendKeys("Sasha123");


        String locator="//ul[@class='colorpicker-list']";
        List<WebElement> allColors =  Driver.getDriver().findElements(By.xpath(locator));
        int lastElement = allColors.size()-1;
        locator="("+locator+")[" + lastElement +"]"+"/li";
        System.out.println("locator = " + locator);
        allColors = Driver.getDriver().findElements(By.xpath(locator));


        for (WebElement each : allColors) {
            String attributeAct = each.getAttribute("style");
            //String attributeExp = "background-color: rgb(241, 219, 80);";
            if (attributeAct.contains("rgb(241, 219, 80)")){
                JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
                executor.executeScript("arguments[0].click();", each);
                //each.click();
                return;
            }else {
                System.out.println("attributeAct = " + attributeAct);
            }
        }

    }



}
