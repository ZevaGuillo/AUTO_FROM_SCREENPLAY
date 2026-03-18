package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.EventsListPage;
import net.serenitybdd.screenplay.Task;

public class NavigateToEventDetail implements Task {

    private final String eventName;

    private NavigateToEventDetail(String eventName) {
        this.eventName = eventName;
    }

    public static NavigateToEventDetail called(String eventName) {
        return new NavigateToEventDetail(eventName);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(EventsListPage.eventLink(eventName)),
            ClickElement.on(EventsListPage.eventLink(eventName))
        );
    }
}