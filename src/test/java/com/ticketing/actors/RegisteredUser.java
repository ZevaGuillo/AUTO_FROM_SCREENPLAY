package com.ticketing.actors;

import net.serenitybdd.screenplay.Actor;

public class RegisteredUser extends Actor {

    private final String username;
    private final String password;

    public RegisteredUser(String name, String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
    }

    public static RegisteredUser asUser(String username, String password) {
        return new RegisteredUser(username, username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}