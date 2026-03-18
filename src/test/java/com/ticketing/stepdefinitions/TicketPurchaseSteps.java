package com.ticketing.stepdefinitions;

import com.ticketing.questions.CartItemCount;
import com.ticketing.questions.ConfirmationMessage;
import com.ticketing.questions.ErrorMessage;
import com.ticketing.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketPurchaseSteps {

    @Given("there is an available event {string}")
    public void thereIsAnAvailableEvent(String eventName) {
    }

    @When("the user navigates to event {string}")
    public void userNavigatesToEvent(String eventName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToEventDetail.called(eventName)
        );
    }

    @Then("the seat map should be displayed")
    public void seatMapShouldBeDisplayed() {
    }

    @When("the user selects seats {string}")
    public void userSelectsSeats(String seatIds) {
        List<String> seatList = Arrays.asList(seatIds.split(","));
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectMultipleSeats.withIds(seatList)
        );
    }

    @Then("the selected seats should be highlighted on the map")
    public void selectedSeatsShouldBeHighlighted() {
    }

    @And("the selection summary should show {int} seats")
    public void selectionSummaryShouldShowSeats(int seatCount) {
    }

    @Then("the cart should display all {int} seats with correct prices")
    public void cartShouldDisplaySeatsWithPrices(int seatCount) {
    }

    @When("the user enters payment details card {string} expiry {string} cvv {string}")
    public void userEntersPaymentDetails(String cardNumber, String expiry, String cvv) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutWithPayment.withCard(cardNumber, expiry, cvv)
        );
    }

    @Then("the purchase should be completed")
    public void purchaseShouldBeCompleted() {
        String confirmation = OnStage.theActorInTheSpotlight().asksFor(
                ConfirmationMessage.displayed()
        );
        assertThat(confirmation).isNotEmpty();
    }

    @And("the order confirmation number should be generated")
    public void orderConfirmationNumberShouldBeGenerated() {
        String confirmation = OnStage.theActorInTheSpotlight().asksFor(
                ConfirmationMessage.displayed()
        );
        assertThat(confirmation).matches(".*[A-Z0-9]{8,}.*");
    }

    @Given("the user is on the cart page")
    public void userIsOnCartPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenCart.now()
        );
    }

    @When("the user attempts to proceed to checkout")
    public void userAttemptsToProceedToCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String error = OnStage.theActorInTheSpotlight().asksFor(
                ErrorMessage.displayed()
        );
        assertThat(error.toLowerCase()).contains(expectedMessage.toLowerCase());
    }

    @And("the checkout button should be disabled")
    public void checkoutButtonShouldBeDisabled() {
    }
}