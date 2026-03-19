package com.ticketing.tasks;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ClickEditEvent implements Task {

    private final String eventName;

    private ClickEditEvent(String eventName) {
        this.eventName = eventName;
    }

    public static Task onEvent(String eventName) {
        return new ClickEditEvent(eventName);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdminEventsPage.EDIT_BUTTON(eventName))
        );
    }
}
