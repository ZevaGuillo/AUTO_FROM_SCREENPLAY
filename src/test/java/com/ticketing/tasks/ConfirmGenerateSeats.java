package com.ticketing.tasks;

import com.ticketing.ui.SeatManagementPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class ConfirmGenerateSeats implements Task {

    public static Task execute() {
        return new ConfirmGenerateSeats();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(SeatManagementPage.GENERATE_BUTTON)
        );
    }
}
