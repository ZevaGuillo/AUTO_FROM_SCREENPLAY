package com.ticketing.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IsSeatReserved {

    public static Question<Boolean> seat(String seatId) {
        return new IsSeatReservedQuestion(seatId);
    }

    private static class IsSeatReservedQuestion implements Question<Boolean> {
        private final String seatId;

        public IsSeatReservedQuestion(String seatId) {
            this.seatId = seatId;
        }

        @Override
        public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
            Target seatElement = Target.the("seat " + seatId)
                    .located(By.xpath("//button[normalize-space()='" + seatId + "']"));
            
            try {
                var element = seatElement.resolveFor(actor);
                String ariaLabel = element.getAttribute("aria-label");
                boolean disabled = element.getAttribute("disabled") != null;
                String classAttr = element.getAttribute("class");
                
                return disabled || (ariaLabel != null && ariaLabel.contains("Reserved")) 
                       || (classAttr != null && classAttr.contains("cursor-not-allowed"));
            } catch (Exception e) {
                return false;
            }
        }
    }
}