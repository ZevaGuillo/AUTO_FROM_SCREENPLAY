package com.ticketing.questions;

import com.ticketing.ui.AdminEventFormPage;
import net.serenitybdd.screenplay.Question;

public class FormSubmissionResult {

    public static Question<Boolean> wasSuccessful() {
        return new SuccessMessageQuestion();
    }

    public static Question<Boolean> hasErrors() {
        return new ErrorPresenceQuestion();
    }

    private static class SuccessMessageQuestion implements Question<Boolean> {
        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            try {
                return AdminEventFormPage.SUCCESS_MESSAGE.resolveFor(actor).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }

    private static class ErrorPresenceQuestion implements Question<Boolean> {
        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            try {
                String error = AdminEventFormPage.ERROR_MESSAGE.resolveFor(actor).getText();
                return error != null && !error.isEmpty();
            } catch (Exception e) {
                return false;
            }
        }
    }
}
