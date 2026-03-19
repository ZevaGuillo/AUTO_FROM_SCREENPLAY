package com.ticketing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class FillEventDate implements Interaction {
    private final Target dateInput;
    private final String eventDate;

    public FillEventDate(Target dateInput, String eventDate) {
        this.dateInput = dateInput;
        this.eventDate = eventDate;
    }

    public static FillEventDate with(Target dateInput, String eventDate) {
        return Tasks.instrumented(FillEventDate.class, dateInput, eventDate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement input = dateInput.resolveFor(actor);
        String formattedDate = eventDate + "T10:00";
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript(
            "const input = arguments[0];" +
            "const value = arguments[1];" +
            "const nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
            "nativeSetter.call(input, value);" +
            "input.dispatchEvent(new Event('input', { bubbles: true }));",
            input, formattedDate
        );
    }
}
