@all
Feature: Event Ticket Selection

  Background:
    Given the user is on the events listing page
    And there is an available event "Concert 2026"

  @positive
  Scenario: User selects multiple seats and completes full purchase
    When the user navigates to event "Concert 2026"
    Then the seat map should be displayed
    When the user selects seats "C1,C2,C3,C4"
    Then the selected seats should be highlighted on the map
    And the selection summary should show 4 seats
    When the user adds the selected seats to cart
    Then the cart should contain 4 items
    And the user opens the cart
    Then the cart should display all 4 seats with correct prices
    When the user proceeds to checkout
    And enters payment details card "4111111111111111" expiry "12/28" cvv "123"
    Then the purchase should be completed
    And the order confirmation number should be generated

  @negative
  Scenario: Checkout fails when cart is empty
    Given the user is on the cart page
    When the user attempts to proceed to checkout
    Then an error message "Your cart is empty" should be displayed
    And the checkout button should be disabled