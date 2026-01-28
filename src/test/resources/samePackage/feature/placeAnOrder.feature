@PlaceOrder
Feature: Place an order
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to place an order successfully

  Scenario: Place an order as active customer
    Given I am on home page
    When I add two products to the cart
    Then products added to the cart
    And I'm on the Checkout page
    And my billing details are
      | firstname | lastname   | country | StreetAddress | city   | state  | zip   | email |
      | josue     | niyonkunda | Rwanda  | Kigali        | Kigali | Rwanda | 93993 | josueniyonkunda@gmail.com |

    Then the order should be placed successfully