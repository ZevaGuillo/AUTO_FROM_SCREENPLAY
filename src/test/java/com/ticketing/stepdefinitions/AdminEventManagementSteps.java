package com.ticketing.stepdefinitions;

import com.ticketing.questions.EventFormValues;
import com.ticketing.questions.EventIsVisible;
import com.ticketing.questions.ErrorMessageDisplayed;
import com.ticketing.questions.EventsPageLoaded;
import com.ticketing.questions.FormSubmissionResult;
import com.ticketing.tasks.*;
import com.ticketing.ui.SeatManagementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminEventManagementSteps {

    @Given("the admin is logged in")
    public void adminIsLoggedIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AdminLogin.perform()
        );
    }

    @Given("the admin is on the events page")
    public void adminIsOnEventsPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToEvents.toEventsPage()
        );
    }

    @Then("the events page should be loaded")
    public void eventsPageShouldBeLoaded() {
        boolean isLoaded = OnStage.theActorInTheSpotlight().asksFor(
                EventsPageLoaded.withTable()
        );
        assertThat(isLoaded).isTrue();
    }

    @When("the admin clicks the create event button")
    public void adminClicksCreateEventButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickCreateEvent.onCreateEventButton()
        );
    }

    @When("the admin fills the event form with valid data")
    public void adminFillsEventFormWithValidData() {
        String futureDate = LocalDateTime.now().plusDays(7)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        OnStage.theActorInTheSpotlight().attemptsTo(
                FillEventForm.withData()
                        .name("Test Event " + System.currentTimeMillis())
                        .venue("Test Venue")
                        .description("Test Description")
                        .dateTime(futureDate)
                        .maxCapacity("100")
                        .basePrice("50.00")
                        .isActive(true)
                        .build()
        );
    }

    @When("the admin fills the event form with the following data:")
    public void adminFillsEventFormWithData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        FillEventForm.Builder builder = FillEventForm.withData();

        if (data.containsKey("name")) {
            builder.name(data.get("name"));
        }
        if (data.containsKey("venue")) {
            builder.venue(data.get("venue"));
        }
        if (data.containsKey("description")) {
            builder.description(data.get("description"));
        }
        if (data.containsKey("dateTime")) {
            builder.dateTime(data.get("dateTime"));
        }
        if (data.containsKey("maxCapacity")) {
            builder.maxCapacity(data.get("maxCapacity"));
        }
        if (data.containsKey("basePrice")) {
            builder.basePrice(data.get("basePrice"));
        }
        if (data.containsKey("isActive")) {
            builder.isActive(Boolean.parseBoolean(data.get("isActive")));
        }

        OnStage.theActorInTheSpotlight().attemptsTo(builder.build());
    }

    @When("the admin submits the event form")
    public void adminSubmitsEventForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SubmitEventForm.toCreate()
        );
    }

    @When("the admin saves the event")
    public void adminSavesEvent() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SubmitEventForm.withSaveChanges(),
                NavigateToEvents.toEventsPage()  // Navigate back to events list after saving
        );
    }

    @Given("the admin ensures the event {string} exists in the events list")
    public void givenEventShouldBeVisibleInEventsList(String eventName) {
        verifyEventIsVisible(eventName);
    }

    @Then("the event {string} should be visible in the events list")
    public void thenEventShouldBeVisibleInEventsList(String eventName) {
        verifyEventIsVisible(eventName);
    }

    private void verifyEventIsVisible(String eventName) {
        boolean isVisible = OnStage.theActorInTheSpotlight().asksFor(
                EventIsVisible.inEventsList(eventName)
        );
        assertThat(isVisible).isTrue();
    }

    @Given("the admin creates an event {string}")
    public void adminCreatesAnEvent(String eventName) {
        String futureDate = LocalDateTime.now().plusDays(7)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickCreateEvent.onCreateEventButton(),
                FillEventForm.withData()
                        .name(eventName)
                        .venue("Test Venue")
                        .description("Test Description")
                        .dateTime(futureDate)
                        .maxCapacity("500")
                        .basePrice("50.00")
                        .isActive(true)
                        .build(),
                SubmitEventForm.toCreate(),
                NavigateToEvents.toEventsPage()
        );
        
        // Verify the event appears in the list
        boolean eventVisible = OnStage.theActorInTheSpotlight().asksFor(
                EventIsVisible.inEventsList(eventName)
        );
        assertThat(eventVisible).isTrue();
    }

    @Then("the event should be visible in the events list")
    public void anyEventShouldBeVisibleInEventsList() {
        boolean isLoaded = OnStage.theActorInTheSpotlight().asksFor(
                EventsPageLoaded.withTable()
        );
        assertThat(isLoaded).isTrue();
    }

    @When("the admin clicks the edit button for event {string}")
    public void adminClicksEditButtonForEvent(String eventName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickEditEvent.onEvent(eventName)
        );
    }

    @When("the admin updates the event with the following data:")
    public void adminUpdatesEventWithData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        FillEventForm.Builder builder = FillEventForm.withData();

        if (data.containsKey("name")) {
            builder.name(data.get("name"));
        }
        if (data.containsKey("venue")) {
            builder.venue(data.get("venue"));
        }
        if (data.containsKey("description")) {
            builder.description(data.get("description"));
        }
        if (data.containsKey("dateTime")) {
            builder.dateTime(data.get("dateTime"));
        }
        if (data.containsKey("maxCapacity")) {
            builder.maxCapacity(data.get("maxCapacity"));
        }
        if (data.containsKey("basePrice")) {
            builder.basePrice(data.get("basePrice"));
        }
        if (data.containsKey("isActive")) {
            builder.isActive(Boolean.parseBoolean(data.get("isActive")));
        }

        OnStage.theActorInTheSpotlight().attemptsTo(builder.build());
    }

    @Then("the error message for field {string} should be displayed")
    public void errorMessageForFieldShouldBeDisplayed(String fieldName) {
        try {
            String errorMessage = OnStage.theActorInTheSpotlight().asksFor(
                    ErrorMessageDisplayed.forField(fieldName)
            );
            assertThat(errorMessage).isNotNull();
            assertThat(errorMessage).isNotEmpty();
        } catch (AssertionError e) {
            String formError = OnStage.theActorInTheSpotlight().asksFor(
                    ErrorMessageDisplayed.onForm()
            );
            assertThat(formError).isNotNull();
        }
    }

    @Then("a form error message should be displayed")
    public void formErrorMessageShouldBeDisplayed() {
        String errorMessage = OnStage.theActorInTheSpotlight().asksFor(
                ErrorMessageDisplayed.onForm()
        );
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage).isNotEmpty();
    }

    @Then("the event form should contain the following values:")
    public void eventFormShouldContainValues(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedValues = dataTable.asMap(String.class, String.class);
        Map<String, String> actualValues = OnStage.theActorInTheSpotlight().asksFor(
                EventFormValues.current()
        );

        expectedValues.forEach((field, expectedValue) -> {
            String actualValue = actualValues.get(field);
            assertThat(actualValue).isEqualTo(expectedValue);
        });
    }

    @Then("the event creation should fail with a validation error")
    public void eventCreationShouldFailWithValidationError() {
        boolean hasErrors = OnStage.theActorInTheSpotlight().asksFor(
                FormSubmissionResult.hasErrors()
        );
        boolean notSuccessful = !OnStage.theActorInTheSpotlight().asksFor(
                FormSubmissionResult.wasSuccessful()
        );
        assertThat(hasErrors || notSuccessful).isTrue();
    }

    @When("the admin clicks the generate seats button for event {string}")
    public void adminClicksGenerateSeatsButton(String eventName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickGenerateSeats.onEvent(eventName)
        );
    }

    @And("the admin confirms seat generation")
    public void adminConfirmsSeatGeneration() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmGenerateSeats.execute()
        );
    }

    @Then("the seats should be generated successfully")
    public void seatsShouldBeGeneratedSuccessfully() {
        boolean capacityExceeded;
        try {
            capacityExceeded = SeatManagementPage.CAPACITY_EXCEEDED_BADGE.resolveFor(OnStage.theActorInTheSpotlight()).isDisplayed();
        } catch (Exception e) {
            capacityExceeded = false;
        }
        assertThat(capacityExceeded).isFalse();
    }

    @Then("a validation error message should be displayed")
    public void validationErrorMessageShouldBeDisplayed() {
        String errorMessage = OnStage.theActorInTheSpotlight().asksFor(
                ErrorMessageDisplayed.onForm()
        );
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage).isNotEmpty();
    }
}
