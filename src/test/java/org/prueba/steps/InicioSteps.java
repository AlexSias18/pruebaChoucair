package org.prueba.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.joda.time.Seconds;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.prueba.page.InicioPage;
import org.prueba.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import java.time.Duration;

import static org.prueba.utils.Utils.*;

public class InicioSteps {
    JavascriptExecutor js=(JavascriptExecutor) Serenity.getDriver();

    private WebDriver driver;
    String script="arguments[0].click();";
    InicioPage inicioPage;
    Utils utils;

    @Step("Abrir pagina")
    public void open(){
       inicioPage.openUrl("https://www.exito.com/");
       screenShotAddCucumber();
    }

    @Step("Elegir categoria")
    public void elegirCategoria() throws InterruptedException {
        inicioPage.burgerMenuBtn.click();
        implicitlyWait(5);
        inicioPage.categoryBtn.click();
        implicitlyWait(5);
        screenShotAddCucumber();
        inicioPage.subCategoryBtn.click();
        screenShotAddCucumber();

    }

    @Step("Elegir productos")
    public void elegirProductos() throws InterruptedException {
        Random random = new Random();
        for (int i = 1; i <=1; i++) {
            int randomIntInRange = random.nextInt(10)+1;
            int randomCantidad = random.nextInt(9)+1;
            implicitlyWait(5);
            WebElementFacade producto = inicioPage.findBy("//*[@id=\"__next\"]/main/section[5]/div/div[2]/div[2]/div[2]/ul/li["+randomIntInRange+"]/article/section/div[2]/div[2]/button");
            WebElementFacade nombre = inicioPage.findBy("//*[@id=\"__next\"]/main/section[5]/div/div[2]/div[2]/div[2]/ul/li["+randomIntInRange+"]/article/section/div[1]/div[1]/div/h3/a");
            if (producto.isCurrentlyVisible()){
                utils.scrollToElement(producto);
                Utils.saveVariableOnSession("nombre"+i,nombre.getText());
                producto.waitUntilVisible();
                producto.waitUntilClickable();
                js.executeScript(script,producto);
            }
            implicitlyWait(5);
            for (int j = 0; j < randomCantidad; j++) {
                WebElementFacade cantidad2=  inicioPage.findBy("//*[@id=\"__next\"]/main/section[5]/div/div[2]/div[2]/div[2]/ul/li["+randomIntInRange+"]/article/section/div[2]/div[2]/div/button[2]");
                utils.scrollToElement(cantidad2);
                cantidad2.waitUntilVisible();
                cantidad2.waitUntilClickable();
                js.executeScript(script,cantidad2);
                implicitlyWait(5);
            }
            implicitlyWait(5);
        }
        inicioPage.carritoBtn.click();
        implicitlyWait(10);
    }

    public void validarProductos() throws InterruptedException {
        implicitlyWait(3);
        for (int i = 1; i <= 1; i++) {
            String producto1= getVariableOnSession("nombre"+i);
            implicitlyWait(3);
            WebElementFacade nombre = inicioPage.findBy("//*[@id=\"render-store.custom.checkout-io\"]/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/div["+i+"]/div/div[4]/span");
            String productocarrito= nombre.getText();
            implicitlyWait(3);
            Assert.assertEquals(producto1,productocarrito);
        }

    }
}

