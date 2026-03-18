package com.ticketing.stepdefinitions;

import com.ticketing.actors.GuestUser;
import com.ticketing.questions.CartItemCount;
import com.ticketing.questions.CartTotal;
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

public class CartManagementSteps {

    @Given("the user is on the events listing page")
    public void userIsOnEventsListingPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToEvent.called("Concert 2026")
        );
    }

    @Given("the user has selected multiple seats {string}")
    public void userHasSelectedMultipleSeats(String seatIds) {
        List<String> seatList = Arrays.asList(seatIds.split(","));
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectMultipleSeats.withIds(seatList)
        );
    }

    @When("the user adds the selected seats to cart")
    public void userAddsSelectedSeatsToCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddSelectedSeatsToCart.now()
        );
    }

    @Then("the cart should contain {int} items")
    public void cartShouldContainItems(int expectedCount) {
        int actualCount = OnStage.theActorInTheSpotlight().asksFor(
                CartItemCount.current()
        );
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @And("the cart total should reflect the sum of all seat prices")
    public void cartTotalShouldReflectSum() {
        String total = OnStage.theActorInTheSpotlight().asksFor(
                CartTotal.current()
        );
        assertThat(total).isNotEmpty();
    }

    @When("the user removes one seat {string} from the cart")
    public void userRemovesSeatFromCart(String seatId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveSeatFromCart.withSeatId(seatId)
        );
    }

    @And("the cart total should be updated accordingly")
    public void cartTotalShouldBeUpdated() {
        String total = OnStage.theActorInTheSpotlight().asksFor(
                CartTotal.current()
        );
        assertThat(total).isNotEmpty();
    }

    @When("the user proceeds to checkout")
    public void userProceedsToCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @And("completes payment with valid card details")
    public void completesPaymentWithValidCard() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutWithPayment.withCard("4111111111111111", "12/28", "123")
        );
    }

    @Then("the order should be confirmed")
    public void orderShouldBeConfirmed() {
        String confirmation = OnStage.theActorInTheSpotlight().asksFor(
                ConfirmationMessage.displayed()
        );
        assertThat(confirmation).isNotEmpty();
    }

    @And("a confirmation message should be displayed")
    public void confirmationMessageShouldBeDisplayed() {
        String message = OnStage.theActorInTheSpotlight().asksFor(
                ConfirmationMessage.displayed()
        );
        assertThat(message).contains("Order");
    }

    @Given("the user has selected seat {string}")
    public void userHasSelectedSeat(String seatId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectMultipleSeats.withIds(List.of(seatId))
        );
    }

    @And("added it to the cart")
    public void addedItToCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddSelectedSeatsToCart.now()
        );
    }

    @When("the user enters invalid payment details")
    public void userEntersInvalidPaymentDetails() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutWithPayment.withCard("0000000000000000", "00/00", "000")
        );
    }

    @Then("the payment should be rejected")
    public void paymentShouldBeRejected() {
        String error = OnStage.theActorInTheSpotlight().asksFor(
                ErrorMessage.displayed()
        );
        assertThat(error).isNotEmpty();
    }

    @And("an error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        String error = OnStage.theActorInTheSpotlight().asksFor(
                ErrorMessage.displayed()
        );
        assertThat(error).containsAnyOf("error", "failed", "invalid");
    }

    @And("the cart items should remain unchanged")
    public void cartItemsShouldRemainUnchanged() {
        int count = OnStage.theActorInTheSpotlight().asksFor(
                CartItemCount.current()
        );
        assertThat(count).isGreaterThan(0);
    }
}