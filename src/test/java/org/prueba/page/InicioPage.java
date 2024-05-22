package org.prueba.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InicioPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"__next\"]/header/section/div/div[1]/button/div")
    public WebElementFacade burgerMenuBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/header/aside/ul/section[2]/div/li[1]/div/div/p")
    public WebElementFacade categoryBtn;
    @FindBy(xpath = "//*[@id=\"column-3\"]/li[1]/ul/li[4]/a")
    public WebElementFacade subCategoryBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/header/section/div/div[2]/div[2]/button")
    public  WebElementFacade carritoBtn;

}
