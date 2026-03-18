package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventDetailPage {

    public static final Target EVENT_TITLE = Target.the("event title")
            .located(By.cssSelector("[data-testid='event-title']"));

    public static final Target SEAT_MAP = Target.the("seat map")
            .located(By.cssSelector("[data-testid='seat-map']"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .located(By.cssSelector("[data-testid='add-to-cart-button']"));

    public static final Target SELECTED_SEATS_COUNT = Target.the("selected seats count")
            .located(By.cssSelector("[data-testid='selected-seats-count']"));

    public static Target seat(String seatId) {
        return Target.the("seat " + seatId)
                .located(By.id("seat-" + seatId));
    }

    private EventDetailPage() {
    }
}