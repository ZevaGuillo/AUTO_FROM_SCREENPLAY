package com.ticketing.tasks;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ClickGenerateSeats implements Task {

    private final String eventName;

    private ClickGenerateSeats(String eventName) {
        this.eventName = eventName;
    }

    public static Task onEvent(String eventName) {
        return new ClickGenerateSeats(eventName);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdminEventsPage.GENERATE_SEATS_BUTTON(eventName))
        );
    }
}
