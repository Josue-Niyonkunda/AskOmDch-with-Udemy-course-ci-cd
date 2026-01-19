Feature: Login Functionality

  In order to do internet shopping
  As a valid Askomd online shopping customer
  I want to login successfully

  Scenario: Login Successful

    Given I am in the login page
    When I enter valid "josue" with "niyonkunda20"
    Then I should be taken to the Overview page

  Scenario: Login UnSuccessfulWithInvalidPassword

    Given I am in the login page
    When I enter invalid password "josue" with "niyon"
    Then I should not be taken to the Overview page

  Scenario: Login UnSuccessfulWithInvalidUsername

    Given I am in the login page
    When I enter invalid username "josueniyonkunda" with "niyonkunda20"
    Then I should not be able to login to the page

  Scenario: Login UnSuccessfulWithEmptyCredentials

    Given I am in the login page
    When I enter invalid with empty credentials "" with ""
    Then I should not be logged to the login page

