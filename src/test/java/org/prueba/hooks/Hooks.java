package org.prueba.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import org.apache.commons.io.FileUtils;
import org.prueba.utils.Constants;
import org.prueba.utils.Utils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.prueba.utils.Utils.saveVariableOnSession;
import static org.prueba.utils.Utils.screenShotAddCucumber;

public class Hooks {

   private Scenario scenario;

   @After
    public void closeDriver(){
       Serenity.getDriver().quit();
   }
    @Before
    public void setScenario(Scenario scenario){
        this.scenario=scenario;
        saveVariableOnSession(Constants.SCENARIO,this.scenario);
   }

   @AfterStep
    public void screenshot(){ screenShotAddCucumber();}
}
