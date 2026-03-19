package com.ticketing.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import net.serenitybdd.core.Serenity;

public class Hooks {

    @Before
    public void setTheStage() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        ChromeDriver driver = new ChromeDriver(options);
        
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Guest User").can(BrowseTheWeb.with(driver));
        
        driver.navigate().to("http://localhost:3000");
    }
}