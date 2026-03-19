package com.ticketing.tasks;

import com.ticketing.ui.EventDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddSelectedSeatsToCart implements Task {

    public AddSelectedSeatsToCart() {
        // Constructor público necesario para la inyección de dependencias
    }

    public static AddSelectedSeatsToCart now() {
        return Tasks.instrumented(AddSelectedSeatsToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(EventDetailPage.RESERVE_AND_ADD_TO_CART_BUTTON, isVisible()),
            Click.on(EventDetailPage.RESERVE_AND_ADD_TO_CART_BUTTON)
        );
    }
}