package com.ticketing.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeatManagementPage {

    public static final Target GENERATE_BUTTON = Target.the("generate seats button")
            .located(By.xpath("//button[contains(@class, 'bg-primary') and contains(normalize-space(), 'Generar Asientos')]"));

    public static final Target CAPACITY_EXCEEDED_BADGE = Target.the("capacity exceeded badge")
            .located(By.xpath("//span[contains(normalize-space(), 'Excede Capacidad')]"));

    public static final Target BACK_TO_EVENT_LINK = Target.the("back to event link")
            .located(By.xpath("//a[contains(normalize-space(), 'Volver al Evento')]"));

    public static final Target TOTAL_SEATS = Target.the("total seats display")
            .located(By.xpath("//div[contains(@class, 'grid')]//p[contains(@class, 'text-2xl')][1]"));

    private SeatManagementPage() {}
}
