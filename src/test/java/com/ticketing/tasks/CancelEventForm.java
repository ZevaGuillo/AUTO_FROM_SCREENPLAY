package com.ticketing.tasks;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CancelEventForm implements Task {

    public static Task toCancel() {
        return new CancelEventForm();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdminEventFormPage.CANCEL_BUTTON)
        );
    }
}
