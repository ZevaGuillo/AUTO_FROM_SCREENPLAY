package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminEventsPage {

    public static final Target EVENTS_TITLE = Target.the("events page title")
            .located(By.xpath("//h1[normalize-space()='Eventos']"));

    public static final Target CREATE_EVENT_BUTTON = Target.the("create event button")
            .located(By.xpath("//button[contains(normalize-space(), 'Crear')]"));

    public static final Target EVENTS_TABLE = Target.the("events table")
            .located(By.xpath("//table"));

    public static final Target LOADING_SPINNER = Target.the("loading spinner")
            .located(By.cssSelector(".loading-spinner"));

    public static Target EVENT_ROW(String eventName) {
        return Target.the("row for event " + eventName)
                .locatedBy("//tr[.//p[contains(@class, 'font-medium') and text()='{0}']]")
                .of(eventName);
    }

    public static Target EDIT_BUTTON(String eventName) {
        return Target.the("edit button for event " + eventName)
                .locatedBy("//tr[.//p[contains(@class, 'font-medium') and text()='{0}']]//button[@data-slot='button'][contains(text(),'Editar')]")
                .of(eventName);
    }

    public static Target GENERATE_SEATS_BUTTON(String eventName) {
        return Target.the("generate seats button for event " + eventName)
                .locatedBy("//tr[.//p[contains(@class, 'font-medium') and text()='{0}']]//button[@data-slot='button'][contains(text(),'Generar')]")
                .of(eventName);
    }

    public static Target EVENT_NAME(String eventName) {
        return Target.the("event name in table")
                .locatedBy("//p[contains(@class, 'font-medium') and text()='{0}']")
                .of(eventName);
    }

    private AdminEventsPage() {}
}
