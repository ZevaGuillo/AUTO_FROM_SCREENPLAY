package com.ticketing.tasks;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ClickCreateEvent implements Task {

    public static Task onCreateEventButton() {
        return new ClickCreateEvent();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdminEventsPage.CREATE_EVENT_BUTTON)
        );
    }
}
