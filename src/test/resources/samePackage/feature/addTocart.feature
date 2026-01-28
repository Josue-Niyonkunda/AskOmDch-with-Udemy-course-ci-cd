Feature: AddToCart functionality
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to add products to the cart successfully by filter

  Scenario: Add two product to the cart from home page
    Given I am on home page
    When I add two products to the cart
    Then products added to the cart
