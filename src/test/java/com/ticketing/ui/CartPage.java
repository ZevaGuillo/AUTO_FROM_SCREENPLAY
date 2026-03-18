package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CART_ITEMS = Target.the("cart items")
            .located(By.cssSelector("[data-testid='cart-items']"));

    public static final Target CART_TOTAL = Target.the("cart total")
            .located(By.cssSelector("[data-testid='cart-total']"));

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.cssSelector("[data-testid='checkout-button']"));

    public static final Target EMPTY_CART_MESSAGE = Target.the("empty cart message")
            .located(By.cssSelector("[data-testid='empty-cart-message']"));

    public static Target seatItem(String seatId) {
        return Target.the("cart item for seat " + seatId)
                .located(By.id("cart-item-" + seatId));
    }

    public static Target removeSeatButton(String seatId) {
        return Target.the("remove button for seat " + seatId)
                .located(By.id("remove-seat-" + seatId));
    }

    private CartPage() {
    }
}