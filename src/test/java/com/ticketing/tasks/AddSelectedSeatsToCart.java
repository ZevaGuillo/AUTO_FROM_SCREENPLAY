package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.EventDetailPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;

public class AddSelectedSeatsToCart implements Task {

    private AddSelectedSeatsToCart() {
    }

    public static AddSelectedSeatsToCart now() {
        return new AddSelectedSeatsToCart();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(EventDetailPage.ADD_TO_CART_BUTTON),
            ClickElement.on(EventDetailPage.ADD_TO_CART_BUTTON)
        );
    }
}