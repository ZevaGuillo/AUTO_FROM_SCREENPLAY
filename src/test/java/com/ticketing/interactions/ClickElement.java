package com.ticketing.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class ClickElement implements Interaction {

    private final Target target;

    public ClickElement(Target target) {
        this.target = target;
    }

    public static ClickElement on(Target target) {
        return new ClickElement(target);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
    }
}