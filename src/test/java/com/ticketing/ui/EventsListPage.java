package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventsListPage {

    // Contenedor principal (más estable basado en heading)
    public static final Target EVENTS_CONTAINER = Target.the("events container")
            .located(By.xpath("//h1[text()='Events']/ancestor::div[1]"));

    // Lista de eventos (cards)
    public static final Target EVENT_CARDS = Target.the("event cards")
            .located(By.cssSelector("div[data-slot='card']"));

    // Nombre del evento
    public static Target eventTitle(String eventName) {
        return Target.the(eventName + " title")
                .located(By.xpath("//h2[normalize-space()='" + eventName + "']"));
    }

    // Botón REAL de navegación (Select Seats)
    public static Target selectSeatsButton(String eventName) {
        return Target.the("Select seats for " + eventName)
                .located(By.xpath(
                        "//h2[normalize-space()='" + eventName + "']" +
                        "/ancestor::div[@data-slot='card']//a[normalize-space()='Select Seats']"
                ));
    }

    private EventsListPage() {}
}