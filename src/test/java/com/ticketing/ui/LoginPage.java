package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USER_ID_INPUT = Target.the("user id input")
            .located(By.id("userId"));

    public static final Target SIGN_IN_BUTTON = Target.the("sign in button")
            .located(By.cssSelector("button[type='submit']"));

    private LoginPage() {}
}