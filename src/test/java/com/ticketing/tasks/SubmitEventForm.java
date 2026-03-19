package com.ticketing.tasks;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SubmitEventForm implements Task {

    private final boolean isCreateMode;

    private SubmitEventForm(boolean isCreateMode) {
        this.isCreateMode = isCreateMode;
    }

    public static Task withSaveChanges() {
        return new SubmitEventForm(false);
    }

    public static Task toCreate() {
        return new SubmitEventForm(true);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        if (isCreateMode) {
            actor.attemptsTo(Click.on(AdminEventFormPage.CREATE_BUTTON));
        } else {
            actor.attemptsTo(Click.on(AdminEventFormPage.SAVE_BUTTON));
        }
    }
}
