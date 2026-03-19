package com.ticketing.tasks;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;

public class GenerateSeats implements Task {

    public static Task forEvent() {
        return new GenerateSeats();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdminEventFormPage.GENERATE_SEATS_BUTTON)
        );
    }
}
