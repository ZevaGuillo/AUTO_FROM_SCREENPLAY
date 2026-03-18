package com.ticketing.actors;

import net.serenitybdd.screenplay.Actor;

public class GuestUser extends Actor {

    public GuestUser() {
        super("Guest User");
    }

    public static GuestUser asGuest() {
        return new GuestUser();
    }
}