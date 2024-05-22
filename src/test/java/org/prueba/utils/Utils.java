package org.prueba.utils;

import freemarker.core.Environment;
import io.cucumber.java.Scenario;
import io.netty.util.Constant;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends PageObject {
    private EnvironmentVariables environmentVariables;

    private static Scenario scenario;

    public static void saveVariableOnSession(String key, Object value){
        Serenity.setSessionVariable(key).to(value);
    }

    public static <T> T getVariableOnSession(String key) { return (T) Serenity.sessionVariableCalled(key);}


    public static  void screenShotAddCucumber(){
        scenario=Utils.getVariableOnSession(Constants.SCENARIO);
        byte[] evidence =((TakesScreenshot) Serenity.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(evidence,"image/png","evidence");
    }

    public static void implicitlyWait(int seconds) throws  InterruptedException{
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void scrollToElement(WebElementFacade webElementFacade){
        evaluateJavascript("arguments[0].scrollIntoView(true);",webElementFacade);
    }



}
