package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.CartPage;
import net.serenitybdd.screenplay.Task;

public class RemoveSeatFromCart implements Task {

    private final String seatIdentifier;

    private RemoveSeatFromCart(String seatIdentifier) {
        this.seatIdentifier = seatIdentifier;
    }

    public static RemoveSeatFromCart withSeatId(String seatId) {
        return new RemoveSeatFromCart(seatId);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(CartPage.removeSeatButton(seatIdentifier)),
            ClickElement.on(CartPage.removeSeatButton(seatIdentifier))
        );
    }
}