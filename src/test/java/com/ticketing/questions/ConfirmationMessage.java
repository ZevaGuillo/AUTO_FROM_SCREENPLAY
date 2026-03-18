package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.ticketing.ui.CheckoutPage;

public class ConfirmationMessage implements Question<String> {

    private ConfirmationMessage() {
    }

    public static ConfirmationMessage displayed() {
        return new ConfirmationMessage();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.of(CheckoutPage.SUCCESS_MESSAGE).answeredBy(actor);
    }
}