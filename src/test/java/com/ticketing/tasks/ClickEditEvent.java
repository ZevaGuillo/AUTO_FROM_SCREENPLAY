package com.ticketing.tasks;

import com.ticketing.ui.AdminEventFormPage;
import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                Click.on(AdminEventsPage.EDIT_BUTTON(eventName)),
                WaitUntil.the(AdminEventFormPage.EVENT_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
