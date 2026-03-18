package com.ticketing.abilities;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class WebNavigation extends BrowseTheWeb {

    private final WebDriver driver;

    public WebNavigation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static WebNavigation usingDriver(WebDriver driver) {
        return new WebNavigation(driver);
    }
}