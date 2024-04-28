Feature: LoginTest

  Background:
    Given user opens the browser and hit url https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

  @loginSuccess @regression @smokeTest
  Scenario: Verify that user should be able to login to Orange HRM system using correct username and password
    When user enters username as Admin and password as admin123
    And user clicks on login button
    Then user lands on Dashboard page

  @loginFailure @regression @smokeTest
  Scenario Outline: Verify that user should not be able to login to Orange HRM system and sees proper error message
    When user enters username as <username> and password as <password>
    And user clicks on login button
    Then user verifies error message as <errorMessage>
    Examples:
      | username | password  | errorMessage        |
      | Admin123 | admin1234 | Invalid credentials |
      | Admin    | admin1234 | Invalid credentials |
      |          |           | Required            |
      | user     | cat@2345  | Invalid credentials |