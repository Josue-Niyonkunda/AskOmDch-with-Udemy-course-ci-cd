Feature: CheckOut functionality
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to checkout my products successfully

  Scenario: Place an order as active customer
    Given I am on home page
    When I add two products to the cart
    Then products added to the cart
    Then I'm on the Checkout page