Feature: Filter functionality
  In order to perform an online shopping
  As askOmdCh online shop customer
  I want to search product successfully by filter

  Scenario Outline: View products by selecting filter
    Given the user is on the online shop store page
    When the user enters product price range <minPrice> and <maxPrice> and click the filter button
    Then only products from range of <minPrice> and <maxPrice> should be displayed

    Examples:
      | minPrice | maxPrice |
      | 10       | 150      |
      | 51       | 100      |



