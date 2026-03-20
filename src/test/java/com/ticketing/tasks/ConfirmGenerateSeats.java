package com.ticketing.tasks;

import com.ticketing.ui.SeatManagementPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmGenerateSeats implements Task {

    public static Task execute() {
        return new ConfirmGenerateSeats();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SeatManagementPage.GENERATE_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SeatManagementPage.GENERATE_BUTTON)
        );
    }
}
