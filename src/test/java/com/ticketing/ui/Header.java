package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Header {

    public static final Target CART_ICON = Target.the("cart icon")
            .located(By.cssSelector("[data-testid='cart-icon']"));

    public static final Target USER_MENU = Target.the("user menu")
            .located(By.cssSelector("[data-testid='user-menu']"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.cssSelector("[data-testid='login-button']"));

    private Header() {
    }
}