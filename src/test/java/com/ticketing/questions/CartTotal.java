package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class CartTotal implements Question<String> {

    private final Target totalElement;

    private CartTotal(Target totalElement) {
        this.totalElement = totalElement;
    }

    public static CartTotal current() {
        return new CartTotal(null);
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        if (totalElement != null) {
            return totalElement.resolveFor(actor).getText();
        }
        return "";
    }
}