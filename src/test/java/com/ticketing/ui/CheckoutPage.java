package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    public static final Target CARD_NUMBER_FIELD = Target.the("card number field")
            .located(By.id("card-number"));

    public static final Target EXPIRY_FIELD = Target.the("expiry date field")
            .located(By.id("expiry-date"));

    public static final Target CVV_FIELD = Target.the("CVV field")
            .located(By.id("cvv"));

    public static final Target PAY_NOW_BUTTON = Target.the("pay now button")
            .located(By.cssSelector("[data-testid='pay-now-button']"));

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .located(By.cssSelector("[data-testid='error-message']"));

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .located(By.cssSelector("[data-testid='success-message']"));

    public static final Target ORDER_SUMMARY = Target.the("order summary")
            .located(By.cssSelector("[data-testid='order-summary']"));

    private CheckoutPage() {
    }
}