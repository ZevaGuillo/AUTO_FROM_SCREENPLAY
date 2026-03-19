@all
Feature: Seat Reservation

  Background:
    Given the user signs in with a valid user ID

  @positive
  Scenario: User reserves a seat successfully
    Given the user is on the events listing page
    When the user navigates to event "Test Concert"
    And the user selects seat "1"
    And the user confirms the reservation
    Then the seat "1" should be reserved
    When the user refreshes the page
    Then the seat "1" should remain reserved

  @negative
  Scenario: User cannot select already reserved seat
    Given the user is on the events listing page
    When the user navigates to event "Test Concert"
    Then the user should not be able to select reserved seats