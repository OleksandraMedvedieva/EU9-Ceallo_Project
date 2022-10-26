package com.cydeo.step_definitions;

import com.cydeo.pages.Dashboard_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.pages.Tasks_Module_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class task_Module_step_definitions {

    Login_Page loginPage = new Login_Page();
    Dashboard_Page dashboardPage = new Dashboard_Page();
    Tasks_Module_Page tasksModulePage = new Tasks_Module_Page();

    @Given("user is on the Ceallo dashboard page")
    public void user_is_on_the_ceallo_dashboard_page() {
        loginPage.login();
    }
    @Given("user click on Tasks module")
    public void user_click_on_tasks_module() {
        dashboardPage.taskModule.click();
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


    @Then("User should see error message: {string}")
    public void userShouldSeeErrorMessage(String arg0) {
        BrowserUtils.waitForVisibility(tasksModulePage.errorMessage,10);
        String actualErrorMessage = tasksModulePage.errorMessage.getText();
        Assert.assertEquals(arg0,actualErrorMessage);
    }

}
