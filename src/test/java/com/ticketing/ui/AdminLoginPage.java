package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminLoginPage {

    public static final Target EMAIL_INPUT = Target.the("admin email input")
            .located(By.name("email"));

    public static final Target PASSWORD_INPUT = Target.the("admin password input")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//button[@type='submit' and contains(normalize-space(), 'Iniciar')]"));

    private AdminLoginPage() {}
}
