Feature: Register Functionality

  In order to do internet shopping
  As a valid Askomd online shopping customer
  I want to register successfully

  Scenario: register with registered account

    Given I am in the contact page
    When I enter credentials "josue" with "josueniyonkunda@gmail.com" with "niyonkunda20"
    Then I should not be registered

  Scenario: Register without email

    Given I am in the contact page
    When I enter credentials "josue" with "" with "niyonkunda20"
    Then I should not be registered on the website

  Scenario: Register without credentials

    Given I am in the contact page
    When I enter credentials "" with "" with ""
    Then I should not be registered on the on the online shop

