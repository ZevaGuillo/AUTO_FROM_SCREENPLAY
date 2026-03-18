package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.Header;
import net.serenitybdd.screenplay.Task;

public class OpenCart implements Task {

    private OpenCart() {
    }

    public static OpenCart now() {
        return new OpenCart();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(Header.CART_ICON),
            ClickElement.on(Header.CART_ICON)
        );
    }
}