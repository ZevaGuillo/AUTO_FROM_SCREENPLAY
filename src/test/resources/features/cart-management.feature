@all
Feature: Cart Management

  Background:
    Given the user signs in with a valid user ID

  @positive
  Scenario: Complete purchase flow with multiple seats
    Given the user is on the events listing page
    And the user has selected seat "3"
    When the user adds the selected seats to cart

  @negative
  Scenario: Purchase fails with invalid payment
    Given the user has selected seat "1"
    And added it to the cart
    When the user proceeds to checkout
    And enters invalid payment details
    Then the payment should be rejected
    And an error message should be displayed
    And the cart items should remain unchanged