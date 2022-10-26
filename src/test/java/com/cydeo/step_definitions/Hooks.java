package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After (order = 1)
    public void teardownScenario(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots,"image/png",scenario.getName());
        }

        Driver.closeDriver();
        //System.out.println("====Closing browser using cucumber @After=====");
        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

}
