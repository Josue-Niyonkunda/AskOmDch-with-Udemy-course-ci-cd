Feature: Reset password Functionality

  In order to do internet shopping
  As a valid AskOmdCh online shopping customer
  I want to reset successfully


  Scenario Outline: reset password

    Given I am in the contact page
    When I click reset link
    And I reset my password  with "<password>"
    Then I should see an alertResetMessage "<message>"
    Examples:
      | password | message                             |
      | josue    | Password reset email has been sent. |
      | josueniyonkunda   | Password reset email has been sent. |