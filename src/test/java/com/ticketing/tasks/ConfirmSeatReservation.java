package com.ticketing.tasks;

import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.EventDetailPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmSeatReservation implements Task {

    private ConfirmSeatReservation() {
    }

    public static ConfirmSeatReservation now() {
        return new ConfirmSeatReservation();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.elementVisible(EventDetailPage.RESERVE_AND_ADD_TO_CART_BUTTON),
                Click.on(EventDetailPage.RESERVE_AND_ADD_TO_CART_BUTTON)
        );
    }
}