package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventsListPage {

    public static final Target EVENTS_CONTAINER = Target.the("events container")
            .located(By.cssSelector("[data-testid='events-list']"));

    public static final Target SEARCH_FIELD = Target.the("search field")
            .located(By.cssSelector("[data-testid='search-field']"));

    public static Target eventLink(String eventName) {
        return Target.the(eventName + " event link")
                .located(By.xpath("//a[contains(text(),'" + eventName + "')]"));
    }

    private EventsListPage() {
    }
}