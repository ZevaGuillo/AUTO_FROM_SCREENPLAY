package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.ticketing.ui.CartPage;

public class CartItemCount implements Question<Integer> {

    private CartItemCount() {
    }

    public static CartItemCount current() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.ofEach(CartPage.CART_ITEMS).answeredBy(actor).size();
    }
}