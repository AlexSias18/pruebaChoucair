package org.prueba.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InicioPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"__next\"]/header/section/div/div[1]/button/div")
    public WebElementFacade burgerMenuBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/header/aside/ul/section[2]/div/li[3]/div/div")
    public WebElementFacade categoryBtn;
    @FindBy(xpath = "//*[@id=\"column-1\"]/li[1]/ul/li[1]/a")
    public WebElementFacade subCategoryBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/header/section/div/div[2]/div[2]/button")
    public  WebElementFacade carritoBtn;

    @FindBy(xpath = "//*[@id=\"wps-overlay-close-button\"]")
    public  WebElementFacade cerrarModal;
}
