package com.ticketing.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenApplication implements Task {

    public static Task atEventsPage() {
        return new OpenApplication();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("http://localhost:3000/events")
        );
    }
}
