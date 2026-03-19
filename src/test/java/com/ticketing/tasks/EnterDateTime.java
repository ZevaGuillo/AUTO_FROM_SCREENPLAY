package com.ticketing.tasks;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnterDateTime implements Interaction {

    private final Target target;
    private final String dateTime;

    private EnterDateTime(Target target, String dateTime) {
        this.target = target;
        this.dateTime = formatDateTime(dateTime);
    }

    public static EnterDateTime into(Target target, String dateTime) {
        return new EnterDateTime(target, dateTime);
    }

    public static EnterDateTime into(Target target, LocalDateTime dateTime) {
        String formatted = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        return new EnterDateTime(target, formatted);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        
        // Use the same approach that works in POM
        js.executeScript(
            "const input = arguments[0];" +
            "const value = arguments[1];" +
            "const nativeSetter = Object.getOwnPropertyDescriptor(" +
            "window.HTMLInputElement.prototype, 'value').set;" +
            "nativeSetter.call(input, value);" +
            "input.dispatchEvent(new Event('input', { bubbles: true }));",
            element,
            dateTime
        );
    }

    private String formatDateTime(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            return "";
        }
        
        // If it's just a date (YYYY-MM-DD), add default time like POM does
        if (dateTime.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return dateTime + "T10:00";
        }
        
        // If it's already in correct datetime-local format (YYYY-MM-DDTHH:mm), return as is
        if (dateTime.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}")) {
            return dateTime;
        }
        
        // Try to parse and reformat if needed
        try {
            LocalDateTime parsed = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            return parsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        } catch (Exception e) {
            // If parsing fails, return the original value
            return dateTime;
        }
    }
}
