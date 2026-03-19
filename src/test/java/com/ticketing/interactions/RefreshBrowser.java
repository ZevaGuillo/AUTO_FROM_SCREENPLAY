package com.ticketing.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class RefreshBrowser implements Interaction {

    public static RefreshBrowser thePage() {
        return new RefreshBrowser();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
    }
}