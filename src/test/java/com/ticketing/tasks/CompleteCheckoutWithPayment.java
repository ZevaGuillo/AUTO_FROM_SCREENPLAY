package com.ticketing.tasks;

import com.ticketing.interactions.ClickElement;
import com.ticketing.interactions.EnterValue;
import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.CheckoutPage;
import net.serenitybdd.screenplay.Task;

public class CompleteCheckoutWithPayment implements Task {

    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    private CompleteCheckoutWithPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public static CompleteCheckoutWithPayment withCard(String cardNumber, String expiry, String cvv) {
        return new CompleteCheckoutWithPayment(cardNumber, expiry, cvv);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitFor.elementVisible(CheckoutPage.CARD_NUMBER_FIELD),
            EnterValue.theValue(cardNumber).into(CheckoutPage.CARD_NUMBER_FIELD),
            EnterValue.theValue(expiryDate).into(CheckoutPage.EXPIRY_FIELD),
            EnterValue.theValue(cvv).into(CheckoutPage.CVV_FIELD),
            ClickElement.on(CheckoutPage.PAY_NOW_BUTTON)
        );
    }
}