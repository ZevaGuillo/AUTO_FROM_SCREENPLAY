package com.ticketing.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class WaitFor implements Interaction {

    private final Target target;
    private final Duration timeout;

    private WaitFor(Target target, Duration timeout) {
        this.target = target;
        this.timeout = timeout;
    }

    public static WaitFor elementVisible(Target target) {
        return new WaitFor(target, Duration.ofSeconds(10));
    }

    public static WaitFor elementClickable(Target target) {
        return new WaitFor(target, Duration.ofSeconds(10));
    }

    public static WaitFor elementPresent(Target target) {
        return new WaitFor(target, Duration.ofSeconds(10));
    }

    public WaitFor forUpTo(long seconds) {
        return new WaitFor(target, Duration.ofSeconds(seconds));
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        target.resolveFor(actor);
    }
}