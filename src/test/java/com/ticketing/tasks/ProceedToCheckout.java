package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.CartPage;
import net.serenitybdd.screenplay.Task;

public class ProceedToCheckout implements Task {

    private ProceedToCheckout() {
    }

    public static ProceedToCheckout now() {
        return new ProceedToCheckout();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(CartPage.CHECKOUT_BUTTON),
            ClickElement.on(CartPage.CHECKOUT_BUTTON)
        );
    }
}