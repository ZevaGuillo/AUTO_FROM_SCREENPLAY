package com.ticketing.questions;

import com.ticketing.ui.AdminEventsPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventsPageLoaded {

    public static Question<Boolean> withTitle() {
        return new EventsPageTitleQuestion();
    }

    public static Question<Boolean> withTable() {
        return new EventsPageTableQuestion();
    }

    private static class EventsPageTitleQuestion implements Question<Boolean> {
        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            try {
                Target title = Target.the("page title")
                        .located(By.xpath("//h1 | //h2 | //*[contains(@class, 'title')]"));
                return title.resolveFor(actor).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }

    private static class EventsPageTableQuestion implements Question<Boolean> {
        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            try {
                return AdminEventsPage.EVENTS_TABLE.resolveFor(actor).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }
}
