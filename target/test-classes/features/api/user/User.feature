Feature: User
  As a admin
  I can manage user
  So that user can be managed

  Scenario: As a admin, I can get all user
    Given I set API endpoint for all user
    When I send request to get all user
    Then I receive status code 200
    And I receive valid data of all user

  Scenario: As a admin, I can get a single user
    Given I set API endpoint for all user
    When I send request to get a single user
    Then I receive status code 200
    And I receive valid data that user

  Scenario: As a admin, I can limits the user result
    Given I set API endpoint for all user
    When I send request to limit the user result
    Then I receive status code 200
    And I receive valid data of all user of limited result

  Scenario: As a admin, I can sort user by descending
    Given I set API endpoint for all user
    When I send request to sort user by descending
    Then I receive status code 200
    And I receive valid data of all user by descending

  Scenario: As a admin, I can sort user by ascending
    Given I set API endpoint for all user
    When I send request to sort user by ascending
    Then I receive status code 200
    And I receive valid data of all user by ascending

  Scenario: As a admin, I can add new user
    Given I set API endpoint for all user
    When I send request to add new user
    Then I receive status code 200
    And I receive valid data of new user

  Scenario: As a admin, I cannot add new user with empty fields
    Given I set API endpoint for all user
    When I send request to add new user with empty fields
    Then I receive status code 400

  Scenario: As a admin, I can update a user
    Given I set API endpoint for all user
    When I send request to update a user
    Then I receive status code 200
    And I receive valid data of updated user

  Scenario: As a admin, I cannot update user with empty fields
    Given I set API endpoint for all user
    When I send request to update user with empty fields
    Then I receive status code 400

  Scenario: As a admin, I can delete a user
    Given I set API endpoint for all user
    When I send request to delete a user
    Then I receive status code 200