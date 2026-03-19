package com.ticketing.tasks;

import com.ticketing.interactions.WaitFor;
import com.ticketing.ui.LoginPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.UUID;

public class SignInWithUserId implements Task {

    private static String generateUserId() {
        return UUID.randomUUID().toString();
    }

    private final String userId;

    private SignInWithUserId(String userId) {
        this.userId = userId;
    }

    public static SignInWithUserId with(String userId) {
        return new SignInWithUserId(userId);
    }

    public static SignInWithUserId defaultUser() {
        return new SignInWithUserId(generateUserId());
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.elementVisible(LoginPage.USER_ID_INPUT).forUpTo(10),
                Enter.theValue(userId).into(LoginPage.USER_ID_INPUT),
                WaitFor.elementClickable(LoginPage.SIGN_IN_BUTTON),
                Click.on(LoginPage.SIGN_IN_BUTTON)
        );
    }
}