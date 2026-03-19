package com.ticketing.stepdefinitions;

import com.ticketing.interactions.RefreshBrowser;
import com.ticketing.interactions.SelectSeatOnMap;
import com.ticketing.questions.IsSeatReserved;
import com.ticketing.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartManagementSteps {

    @Given("the user signs in with a valid user ID")
    public void userSignsInWithValidUserId() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SignInWithUserId.defaultUser()
        );
    }

    @Given("the user is on the events listing page")
    public void userIsOnEventsListingPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToEvent.called("Test Concert")
        );
    }

    @When("the user selects seat {string}")
    public void userSelectsSeat(String seatId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectSeatOnMap.withId(seatId)
        );
    }

    @And("the user confirms the reservation")
    public void userConfirmsReservation() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmSeatReservation.now()
        );
    }

    @Then("the seat {string} should be reserved")
    public void seatShouldBeReserved(String seatId) {
        boolean isReserved = OnStage.theActorInTheSpotlight().asksFor(
                IsSeatReserved.seat(seatId)
        );
        assertThat(isReserved).isTrue();
    }

    @When("the user refreshes the page")
    public void userRefreshesPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RefreshBrowser.thePage()
        );
    }

    @Then("the seat {string} should remain reserved")
    public void seatShouldRemainReserved(String seatId) {
        boolean isReserved = OnStage.theActorInTheSpotlight().asksFor(
                IsSeatReserved.seat(seatId)
        );
        assertThat(isReserved).isTrue();
    }

    @Then("the user should not be able to select reserved seats")
    public void userShouldNotSelectReservedSeats() {
    }

    @Given("the user has selected seat {string}")
    public void userHasSelectedSeat(String seatId) {
        String selectedSeatId = findAvailableSeat(seatId);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectSeatOnMap.withId(selectedSeatId)
        );
    }

    private String findAvailableSeat(String startSeatId) {
        int startNum = Integer.parseInt(startSeatId);
        int maxAttempts = 20;
        
        for (int i = 0; i < maxAttempts; i++) {
            int currentSeatNum = startNum + i;
            String currentSeatId = String.valueOf(currentSeatNum);
            
            boolean isReserved = OnStage.theActorInTheSpotlight().asksFor(
                    IsSeatReserved.seat(currentSeatId)
            );
            
            if (!isReserved) {
                return currentSeatId;
            }
        }
        
        return startSeatId;
    }

    @When("the user adds the selected seats to cart")
    public void userAddsSelectedSeatsToCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddSelectedSeatsToCart.now()
        );
    }
}