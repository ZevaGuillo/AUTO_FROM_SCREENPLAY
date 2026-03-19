@admin
Feature: Admin Event Management

  Background:
    Given the admin is logged in
    And the admin is on the events page
    Then the events page should be loaded

  @edit-event
  Scenario: Admin edits an existing event
    Given the admin creates an event "Tech Conference 2027"
    When the admin clicks the edit button for event "Tech Conference 2027"
    And the admin updates the event with the following data:
      | name          | Tech Conference 2027 - Updated  |
      | venue         | Grand Convention Center         |
    And the admin saves the event
    Then the event "Tech Conference 2027 - Updated" should be visible in the events list

  @generate-seats
  Scenario: Admin generates seats for an event
    Given the admin creates an event "Tech Conference 2027"
    When the admin clicks the generate seats button for event "Tech Conference 2027"
    And the admin confirms seat generation
    Then the seats should be generated successfully

  @create-event
  Scenario: Admin attempts to create event with invalid data
    When the admin clicks the create event button
    And the admin fills the event form with the following data:
      | name          |                              |
      | venue         |                              |
    And the admin submits the event form
    Then a validation error message should be displayed
