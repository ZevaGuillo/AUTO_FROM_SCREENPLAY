package com.ticketing.questions;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;
import java.util.Map;

public class EventFormValues {

    public static Question<Map<String, String>> current() {
        return new EventFormValuesQuestion();
    }

    private static class EventFormValuesQuestion implements Question<Map<String, String>> {
        @Override
        public Map<String, String> answeredBy(net.serenitybdd.screenplay.Actor actor) {
            Map<String, String> values = new HashMap<>();

            try {
                values.put("name", AdminEventFormPage.EVENT_NAME_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                values.put("venue", AdminEventFormPage.VENUE_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                values.put("description", AdminEventFormPage.DESCRIPTION_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                values.put("dateTime", AdminEventFormPage.DATE_TIME_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                values.put("maxCapacity", AdminEventFormPage.MAX_CAPACITY_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                values.put("basePrice", AdminEventFormPage.BASE_PRICE_INPUT.resolveFor(actor).getAttribute("value"));
            } catch (Exception ignored) {}

            try {
                String checked = AdminEventFormPage.ACTIVE_CHECKBOX.resolveFor(actor).getAttribute("checked");
                values.put("isActive", checked != null ? "true" : "false");
            } catch (Exception ignored) {}

            return values;
        }
    }
}
