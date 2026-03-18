package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.EventsListPage;
import net.serenitybdd.screenplay.Task;

public class NavigateToEvent implements Task {

    private final String eventName;

    private NavigateToEvent(String eventName) {
        this.eventName = eventName;
    }

    public static NavigateToEvent called(String eventName) {
        return new NavigateToEvent(eventName);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.elementVisible(EventsListPage.EVENTS_CONTAINER),
                ClickElement.on(EventsListPage.eventLink(eventName))
        );
    }
}