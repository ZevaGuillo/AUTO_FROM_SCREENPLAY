package com.ticketing.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectSeatOnMap implements Interaction {

    private final String seatId;
    private final Target seatMapContainer;

    private SelectSeatOnMap(String seatId, Target seatMapContainer) {
        this.seatId = seatId;
        this.seatMapContainer = seatMapContainer;
    }

    public static SelectSeatOnMap withId(String seatId) {
        return new SelectSeatOnMap(seatId, null);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        Target seatElement = Target.the("seat " + seatId)
                .located(By.id("seat-" + seatId));
        seatElement.resolveFor(actor).click();
    }
}