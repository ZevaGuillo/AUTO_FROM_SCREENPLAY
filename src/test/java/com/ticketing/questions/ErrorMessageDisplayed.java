package com.ticketing.questions;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ErrorMessageDisplayed {

    public static Question<String> forField(String fieldName) {
        return new FieldErrorQuestion(fieldName);
    }

    public static Question<String> onForm() {
        return new FormErrorQuestion();
    }

    private static class FieldErrorQuestion implements Question<String> {
        private final String fieldName;

        public FieldErrorQuestion(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
            Target errorTarget = Target.the(fieldName + " error")
                    .locatedBy("//input[@id='" + fieldName.toLowerCase() + "']/following-sibling::*[contains(@class, 'error')] | //input[@id='" + fieldName.toLowerCase() + "']/..//*[contains(@class, 'error')] | //span[contains(@class, 'field-error') and contains(text(), '" + fieldName + "')]");
            try {
                return errorTarget.resolveFor(actor).getText();
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static class FormErrorQuestion implements Question<String> {
        @Override
        public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
            try {
                return AdminEventFormPage.ERROR_MESSAGE.resolveFor(actor).getText();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
