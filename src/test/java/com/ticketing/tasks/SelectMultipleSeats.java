package com.ticketing.tasks;

import com.ticketing.interactions.SelectSeatOnMap;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class SelectMultipleSeats implements Task {

    private final List<String> seatIds;

    private SelectMultipleSeats(List<String> seatIds) {
        this.seatIds = seatIds;
    }

    public static SelectMultipleSeats withIds(List<String> seatIds) {
        return new SelectMultipleSeats(seatIds);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        for (String seatId : seatIds) {
            actor.attemptsTo(
                SelectSeatOnMap.withId(seatId)
            );
        }
    }
}