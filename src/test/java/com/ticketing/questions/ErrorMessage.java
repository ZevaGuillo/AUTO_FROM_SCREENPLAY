package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.ticketing.ui.CheckoutPage;

public class ErrorMessage implements Question<String> {

    private ErrorMessage() {
    }

    public static ErrorMessage displayed() {
        return new ErrorMessage();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.of(CheckoutPage.ERROR_MESSAGE).answeredBy(actor);
    }
}