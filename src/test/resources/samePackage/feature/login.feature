Feature: Login Functionality

  In order to do internet shopping
  As a valid AskOmdCh online shopping customer
  I want to login successfully

  Background: login
    Given I am in the login page

  Scenario Outline: Login validCredentials
    When I enter valid "<userName>" with "<Password>"
    Then I should see the status alertMessage "<message>"
    Examples:
      | userName        | Password     | message                                              |
      | josue           | niyonkunda20 | Hello josue (not josue? Log out)                     |
      | josueniyonkunda | niyonkunda20 | Hello josueniyonkunda (not josueniyonkunda? Log out) |


  Scenario Outline: Login InvalidCredentials
    When I enter valid "<userName>" with "<Password>"
    Then I should see the errorMessage "<message>"
    Examples:
      | userName        | Password     | message                                                                                  |
      | josue           | niyon        | Error: The password you entered for the username josue is incorrect. Lost your password? |
      |                 | niyonkunda20 | Error: Username is required.                                                             |
      | josueniyonkunda |              | Error: The password field is empty.                                                      |




