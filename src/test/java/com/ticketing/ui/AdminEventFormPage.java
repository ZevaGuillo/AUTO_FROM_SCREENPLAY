package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminEventFormPage {

    public static final Target EVENT_NAME_INPUT = Target.the("event name input")
            .located(By.id("name"));

    public static final Target VENUE_INPUT = Target.the("venue input")
            .located(By.id("venue"));

    public static final Target DESCRIPTION_INPUT = Target.the("description input")
            .located(By.id("description"));

    public static final Target DATE_TIME_INPUT = Target.the("date and time input")
            .located(By.id("eventDate"));

    public static final Target MAX_CAPACITY_INPUT = Target.the("max capacity input")
            .located(By.id("maxCapacity"));

    public static final Target BASE_PRICE_INPUT = Target.the("base price input")
            .located(By.id("basePrice"));

    public static final Target ACTIVE_CHECKBOX = Target.the("active status checkbox")
            .located(By.id("isActive"));

    public static final Target CREATE_BUTTON = Target.the("create event button")
            .located(By.xpath("//button[@type='submit' and contains(normalize-space(), 'Crear')]"));

    public static final Target SAVE_BUTTON = Target.the("save button")
            .located(By.xpath("//button[@type='submit' and contains(normalize-space(), 'Guardar')]"));

    public static final Target CANCEL_BUTTON = Target.the("cancel button")
            .located(By.xpath("//button[contains(normalize-space(), 'Cancelar')]"));

    public static final Target ERROR_MESSAGE = Target.the("form error message")
            .located(By.xpath("//p[contains(@class, 'text-destructive')]"));

    public static final Target SUCCESS_MESSAGE = Target.the("form success message")
            .located(By.cssSelector("[data-success-message]"));

    public static final Target GENERATE_SEATS_BUTTON = Target.the("generate seats button")
            .located(By.xpath("//button[@data-slot='button' and contains(text(), 'Generar')]"));

    public static Target fieldError(String fieldName) {
        return Target.the(fieldName + " error message")
                .located(By.cssSelector("[data-error-message]"));
    }

    private AdminEventFormPage() {}
}
