package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.ticketing.ui.CartPage;

public class SeatStatus implements Question<String> {

    private final String seatId;

    private SeatStatus(String seatId) {
        this.seatId = seatId;
    }

    public static SeatStatus of(String seatId) {
        return new SeatStatus(seatId);
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.of(CartPage.seatItem(seatId)).answeredBy(actor);
    }
}