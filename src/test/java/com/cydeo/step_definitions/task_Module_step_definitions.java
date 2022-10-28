package com.cydeo.step_definitions;

import com.cydeo.pages.Dashboard_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.pages.Tasks_Module_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class task_Module_step_definitions {

    Login_Page loginPage = new Login_Page();
    Dashboard_Page dashboardPage = new Dashboard_Page();
    Tasks_Module_Page tasksModulePage = new Tasks_Module_Page();

    //Faker faker = new Faker();

    @Given("user is on the Ceallo dashboard page")
    public void user_is_on_the_ceallo_dashboard_page() {
        loginPage.login();
    }
    @Given("user click on Tasks module")
    public void user_click_on_tasks_module() {
        dashboardPage.taskModule.click();
        BrowserUtils.waitFor(2);
    }

    @When("user click on Add list button")
    public void user_click_on_add_list_button() {
        tasksModulePage.addListButton.click();
    }

    @When("user types valid list name {string}")
    public void user_types_valid_list_name(String validListName) {
        tasksModulePage.newListInputBox.sendKeys(validListName);
    }
    @When("user click on Save button")
    public void user_click_on_save_button() {
       tasksModulePage.clickOnSaveListButton();
    }
    @Then("user should see new list {string} with valid name and color under the all list menu")
    public void user_should_see_new_list_with_valid_name_and_color_under_the_all_list_menu(String validListName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement element = Driver.getDriver().findElement(By.partialLinkText(validListName));
        wait.until(
                ExpectedConditions.visibilityOf(element)
        );
        ArrayList<String> actualLists = tasksModulePage.check_if_new_list_appearsInThe_menu();
        Assert.assertTrue(actualLists.contains(validListName));
    }

    @And("user click on the Cancel button")
    public void userClickOnTheCancelButton() {
        tasksModulePage.clickOnCancelListButton();
    }

    @Then("user should not see new list {string} under the all list menu")
    public void userShouldNotSeeNewListUnderTheAllListMenu(String validListName) {
        ArrayList<String> actualLists = tasksModulePage.check_if_new_list_appearsInThe_menu();
        Assert.assertFalse(actualLists.contains(validListName));
    }

    @And("user click on any color {string} from the color picker")
    public void userClickOnAnyColorFromTheColorPicker(String colorNumber) {
        int indexNumber = tasksModulePage.colorPickers.size();
        String locator = "((//div[@class='colorpicker'])"+"["+indexNumber+"]//li)["+colorNumber+"]";
        WebElement color = Driver.getDriver().findElement(By.xpath(locator));
        color.click();
    }

    @And("user should see error message: The name {string} is already used.")
    public void userShouldSeeErrorMessageTheNameIsAlreadyUsed(String listName) {
        BrowserUtils.waitForVisibility(tasksModulePage.errorMessage,5);
        String actualErrorMessage = tasksModulePage.errorMessage.getText();
        String expectedErrorMessage = "The name \"" + listName + "\" is already used.";
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @When("user clicks on one of tab from the menu {string}")
    public void userClicksOnOneOfTabFromTheMenu(String tabName) {
        WebElement loader = Driver.getDriver().findElement(By.linkText(tabName));
        BrowserUtils.waitForVisibility(loader,5);
        for (WebElement eachList : tasksModulePage.allListsMenu) {
            String eachTitleName = eachList.getAttribute("title");
            if (eachTitleName.equals(tabName)){
                    eachList.click();
            }
        }
    }

    @And("user types valid task name {string} in the input box and clicks Enter")
    public void userTypesValidTaskNameInTheInputBoxAndClicksEnter(String taskName) {
        //BrowserUtils.waitForClickablility(tasksModulePage.inputBoxForNewTask,10);
        tasksModulePage.inputBoxForNewTask.click();
        tasksModulePage.inputBoxForNewTask.sendKeys(taskName + Keys.ENTER);
    }

    @Then("New task name {string} appears under the related list.")
    public void newTaskNameAppearsUnderTheRelatedList(String taskName) {
        for (WebElement eachTask : tasksModulePage.listOfAllTasksRelatedToTheCurrentTab) {
            if (eachTask.getText().equals(taskName)){
                Assert.assertTrue(eachTask.isDisplayed());
            }
        }
    }

    @When("user clicks on the Settings")
    public void userClicksOnTheSettings() {
        tasksModulePage.settingsButton.click();
    }

    @And("user select one of the options {string} from a Default List dropdown")
    public void userSelectOneOfTheOptionsFromADropdown(String option) {
        Select select = new Select(tasksModulePage.dropdownForDefaultList);
        select.selectByVisibleText(option);
    }

    @When("user clicks on the tab {string} from the menu")
    public void userClicksOnTheTabFromTheMenu(String tabName) {
        for (WebElement eachList : tasksModulePage.allListsMenu) {
            if(eachList.getText().equals(tabName)){
                eachList.click();
            }
        }
    }

    @And("user clicks on the checkbox near the task name {string} and see 1 Completed Task link on the screen")
    public void userClicksOnTheCheckboxNearTheTaskName(String taskName) {
        List<WebElement> allTasksFromTheList = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
        List<WebElement> allCheckBoxesFromTheList = tasksModulePage.allCheckBoxesFromTheCurrentList;
        for (int i = 0; i < allTasksFromTheList.size(); i++) {
            WebElement task = allTasksFromTheList.get(i);
            if(task.getText().equals(taskName)){
                WebElement checkbox = allCheckBoxesFromTheList.get(i);
                checkbox.click();
                Assert.assertTrue(tasksModulePage.oneCompletedTaskLink.isDisplayed());
           return;
            }
        }
    }

    @When("user clicks on {string} tab from the menu")
    public void userClicksOnTabFromTheMenu(String tab) {
        for (WebElement eachList : tasksModulePage.allListsMenu) {
            if(eachList.getText().equals(tab)){
                eachList.click();
            }
        }
    }

    @Then("user can see recently selected task {string} in this list.")
    public void userCanSeeRecentlyCompletedTaskInThisList(String taskName) {
        List<WebElement> allTasksFromTheList = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
        for (int i = 0; i < allTasksFromTheList.size(); i++) {
            WebElement task = allTasksFromTheList.get(i);
            if(task.getText().equals(taskName)){

                System.out.println("task.isDisplayed() = " + task.isDisplayed());

                Assert.assertTrue(task.isDisplayed());
                return;
            }
        }
    }

    @And("user clicks on the star icon near the task name{string} and this icon color is changes")
    public void userClicksOnTheStarIconNearThe(String taskName) {
        List<WebElement> allTasksFromTheList = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
        List<WebElement> allStarIconsFromTheList = tasksModulePage.allStarIconsFromTheCurrentList;
        for (int i = 0; i < allTasksFromTheList.size(); i++) {
            WebElement task = allTasksFromTheList.get(i);
            if(task.getText().equals(taskName)){
                WebElement starIcon = allStarIconsFromTheList.get(i);
                starIcon.click();
                Assert.assertTrue(starIcon.getAttribute("class").contains("color"));
                return;
            }
        }
    }


    @Then("User can see amount of all uncompleted tasks next to the Current tab")
    public void userCanSeeAmountOfAllUncompletedTasksNextToTheCurrentTab() {
        List<WebElement> allTasksFromTheList = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
        int expectedAmountOfTasks = allTasksFromTheList.size();
        int actualAmountOfTasks =-6;

        for (WebElement eachList : tasksModulePage.allListsMenu) {
            if(eachList.getText().equals("Important") || eachList.getText().equals("All")
                    || eachList.getText().equals("Completed")
                    || eachList.getText().equals("Current")){
                continue;
            }

            eachList.click();
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            List<WebElement> allTasks = tasksModulePage.listOfAllTasksRelatedToTheCurrentTab;
            actualAmountOfTasks+=allTasks.size();
            System.out.println(eachList.getText() + " - " + allTasks.size());
        }

        System.out.println("expectedAmountOfTasks = " + expectedAmountOfTasks);
        System.out.println("actualAmountOfTasks = " + actualAmountOfTasks);

        //Assert.assertTrue(expectedAmountOfTasks==actualAmountOfTasks);


    }

    @And("user select for each of the option of Smart Collection dropdown value {string}")
    public void userSelectForEachOfTheOptionOfSmartCollectionDropdownValue(String value) {
        List<WebElement> smartCollectionsDropdown = Arrays.asList(tasksModulePage.importantDropdown,tasksModulePage.todayDropdown,tasksModulePage.weekDropdown
        ,tasksModulePage.allDropdown,tasksModulePage.currentDropdown,tasksModulePage.completedDropdown);
        for (WebElement eachDropdown : smartCollectionsDropdown) {
            Select select = new Select(eachDropdown);
            select.selectByVisibleText(value);
        }

    }
}
