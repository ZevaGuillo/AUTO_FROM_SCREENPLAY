@all
Feature: Cart Management

  Background:
    Given the user is on the events listing page

  @positive
  Scenario: Complete purchase flow with multiple seats
    Given the user has selected multiple seats "A1,A2,A3"
    When the user adds the selected seats to cart
    Then the cart should contain 3 items
    And the cart total should reflect the sum of all seat prices
    When the user removes one seat "A2" from the cart
    Then the cart should contain 2 items
    And the cart total should be updated accordingly
    When the user proceeds to checkout
    And completes payment with valid card details
    Then the order should be confirmed
    And a confirmation message should be displayed

  @negative
  Scenario: Purchase fails with invalid payment
    Given the user has selected seat "B5"
    And added it to the cart
    When the user proceeds to checkout
    And enters invalid payment details
    Then the payment should be rejected
    And an error message should be displayed
    And the cart items should remain unchanged