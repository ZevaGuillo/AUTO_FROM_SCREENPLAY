package com.ticketing.tasks;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToEvents implements Task {

    public static Task toEventsPage() {
        return new NavigateToEvents();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("http://localhost:3000/admin/events"),
                WaitUntil.the(AdminEventsPage.EVENTS_TABLE, isVisible()).forNoMoreThan(5).seconds()
        );
    }
}
