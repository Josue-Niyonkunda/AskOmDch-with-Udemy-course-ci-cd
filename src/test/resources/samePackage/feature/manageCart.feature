Feature: Cart management functionality
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to manage my cart.

  Scenario: update products in the cart
    Given I am on cart page
    When I want to increment each product by one
    Then I should see an update confirmation

  Scenario: delete products from the cart
    Given I am on cart page
    When I want to delete the product
    Then I should see an delete confirmation

