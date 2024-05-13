Feature: Login
  As a user
  I want to login
  So that i can get a token

  Scenario: As a user, I can login with valid credentials
    Given I set API endpoint for login
    When I send request to login with valid username and password
    Then I receive status code 200
    And I get a token

  Scenario: As a user, I cannot login with invalid username
    Given I set API endpoint for login
    When I send request to login with invalid username and valid password
    Then I receive status code 401


  Scenario: As a user, I cannot login with invalid password
    Given I set API endpoint for login
    When I send request to login with valid username and invalid password
    Then I receive status code 401


  Scenario: As a user, I cannot login with empty username
    Given I set API endpoint for login
    When I send request to login with empty username and valid password
    Then I receive status code 400


  Scenario: As a user, I cannot login with empty password
    Given I set API endpoint for login
    When I send request to login with valid username and empty password
    Then I receive status code 400


