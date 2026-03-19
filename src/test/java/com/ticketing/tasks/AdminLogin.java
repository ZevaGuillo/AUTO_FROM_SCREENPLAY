package com.ticketing.tasks;

import com.ticketing.ui.AdminLoginPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;

public class AdminLogin implements Task {

    private static final String ADMIN_EMAIL = "admin@ticketing.com";
    private static final String ADMIN_PASSWORD = "Admin123!";

    public static Task perform() {
        return new AdminLogin();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("http://localhost:3000/admin/login"),
                Enter.theValue(ADMIN_EMAIL).into(AdminLoginPage.EMAIL_INPUT),
                Enter.theValue(ADMIN_PASSWORD).into(AdminLoginPage.PASSWORD_INPUT),
                Click.on(AdminLoginPage.LOGIN_BUTTON)
        );
    }
}
