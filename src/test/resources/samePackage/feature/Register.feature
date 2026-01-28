Feature: Register Functionality

  In order to do internet shopping
  As a valid Askomd online shopping customer
  I want to register successfully


  Scenario Outline: register with registered accounts

    Given I am in the contact page
    When I register my credentials "<userName>" with "<email>" with "<password>"
    Then I should not be registered and see an alertErrorMessage "<message>"
    Examples:
      | userName        | email                     | password     | message                                                                         |
      | josue           | josueniyonkunda@gmail.com | niyonkunda20 | Error: An account is already registered with your email address. Please log in. |
      | josueniyonkunda | josueniyonkunda@gmail.com | niyonkunda20 | Error: An account is already registered with your email address. Please log in. |

  Scenario Outline: register with invalidCredentials

    Given I am in the contact page
    When I register my credentials "<username>" with "<Email>" with "<Password>"
    Then I should not be registered and see an alertErrorMessage "<Message>"
    Examples:
      | username | Email                    | Password     | Message                                       |
      | josue    |                          | niyonkunda20 | Error: Please provide a valid email address.  |
      | jos      | josueniyonkund@gmail.com |              | Error: Please enter an account password.      |
      |          | josueniyonkund@gmail.com | niyonkunda20 | Error: Please enter a valid account username. |


