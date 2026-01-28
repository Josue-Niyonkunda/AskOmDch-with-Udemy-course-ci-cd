Feature: sorting functionality
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to search product successfully by search functionality

  Scenario Outline: View products by selecting category from dropdown
    Given the user is on the online shop homepage
    When the user search product "<product>" from the search field
    Then only products from "<message>" search text should be displayed
    Examples:
      | product | message                 |
      | shoe    | Search results: “shoe”  |
      | shirt   | Search results: “shirt” |