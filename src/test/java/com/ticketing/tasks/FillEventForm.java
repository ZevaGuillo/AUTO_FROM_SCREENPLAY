package com.ticketing.tasks;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FillEventForm implements Task {

    private final String name;
    private final String venue;
    private final String description;
    private final String dateTime;
    private final String maxCapacity;
    private final String basePrice;
    private final boolean isActive;

    private FillEventForm(Builder builder) {
        this.name = builder.name;
        this.venue = builder.venue;
        this.description = builder.description;
        this.dateTime = builder.dateTime;
        this.maxCapacity = builder.maxCapacity;
        this.basePrice = builder.basePrice;
        this.isActive = builder.isActive;
    }

    public static Builder withData() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String venue;
        private String description;
        private String dateTime;
        private String maxCapacity;
        private String basePrice;
        private boolean isActive = true;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder venue(String venue) {
            this.venue = venue;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            return this;
        }

        public Builder maxCapacity(String maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public Builder basePrice(String basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public FillEventForm build() {
            return new FillEventForm(this);
        }
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        if (name != null) {
            actor.attemptsTo(
                    Clear.field(AdminEventFormPage.EVENT_NAME_INPUT),
                    Enter.theValue(name).into(AdminEventFormPage.EVENT_NAME_INPUT)
            );
        }
        if (venue != null) {
            actor.attemptsTo(
                    Clear.field(AdminEventFormPage.VENUE_INPUT),
                    Enter.theValue(venue).into(AdminEventFormPage.VENUE_INPUT)
            );
        }
        if (description != null) {
            actor.attemptsTo(
                    Clear.field(AdminEventFormPage.DESCRIPTION_INPUT),
                    Enter.theValue(description).into(AdminEventFormPage.DESCRIPTION_INPUT)
            );
        }
        if (dateTime != null) {
            actor.attemptsTo(EnterDateTime.into(AdminEventFormPage.DATE_TIME_INPUT, dateTime));
        }
        if (maxCapacity != null) {
            actor.attemptsTo(
                    Clear.field(AdminEventFormPage.MAX_CAPACITY_INPUT),
                    Enter.theValue(maxCapacity).into(AdminEventFormPage.MAX_CAPACITY_INPUT)
            );
        }
        if (basePrice != null) {
            actor.attemptsTo(
                    Clear.field(AdminEventFormPage.BASE_PRICE_INPUT),
                    Enter.theValue(basePrice).into(AdminEventFormPage.BASE_PRICE_INPUT)
            );
        }
        if (!isActive) {
            actor.attemptsTo(JavaScriptClick.on(AdminEventFormPage.ACTIVE_CHECKBOX));
        }
    }
}
