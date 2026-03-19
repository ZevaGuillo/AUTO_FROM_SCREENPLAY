package com.ticketing.questions;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class EventIsVisible {

    public static Question<Boolean> inEventsList(String eventName) {
        return new EventVisibilityQuestion(eventName);
    }

    private static class EventVisibilityQuestion implements Question<Boolean> {
        private final String eventName;

        public EventVisibilityQuestion(String eventName) {
            this.eventName = eventName;
        }

        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            Target eventCell = AdminEventsPage.EVENT_NAME(eventName);
            try {
                return eventCell.resolveFor(actor).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }
}
