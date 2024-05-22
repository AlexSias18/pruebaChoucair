package org.prueba.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By userInput = By.id("login_form_email");
    public static By passwordInput= By.id("login_form_password");
    public static By LoginButton = By.xpath("//*[@id=\"login-form\"]/form/button");
}
