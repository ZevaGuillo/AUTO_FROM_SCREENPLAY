package com.ticketing.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class EnterValue implements Interaction {

    private final String value;
    private final Target target;
    private final boolean clearFirst;

    private EnterValue(String value, Target target, boolean clearFirst) {
        this.value = value;
        this.target = target;
        this.clearFirst = clearFirst;
    }

    public static EnterValueBuilder theValue(String value) {
        return new EnterValueBuilder(value);
    }

    public static class EnterValueBuilder {
        private final String value;

        public EnterValueBuilder(String value) {
            this.value = value;
        }

        public Interaction into(Target target) {
            return new EnterValue(value, target, true);
        }

        public Interaction into(Target target, boolean clearFirst) {
            return new EnterValue(value, target, clearFirst);
        }
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        if (clearFirst) {
            target.resolveFor(actor).clear();
        }
        target.resolveFor(actor).sendKeys(value);
    }
}