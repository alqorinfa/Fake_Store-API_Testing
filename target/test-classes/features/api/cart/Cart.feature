Feature: Cart
  As a user
  I want to manage my cart
  So that I can checkout products

  Scenario: As a user, I can get all carts
    Given I set API endpoint for all carts
    When I send request to get all carts
    Then I receive status code 200
    And I receive valid data of all carts

  Scenario: As a user, I can get single cart
    Given I set API endpoint for all carts
    When I send request to get single cart
    Then I receive status code 200
    And I receive valid data of single cart

  Scenario: As a user, I can limit cart result
    Given I set API endpoint for all carts
    When I send request to limit carts
    Then I receive status code 200
    And I receive valid data of limit carts

  Scenario: As a user, I can sort carts by descending
    Given I set API endpoint for all carts
    When I send request to sort carts by descending
    Then I receive status code 200
    And I receive valid data of all cart by descending

  Scenario: As a user, I can sort carts by ascending
    Given I set API endpoint for all carts
    When I send request to sort carts by ascending
    Then I receive status code 200
    And I receive valid data of all carts by ascending

  Scenario: As a user, I can get other user carts
    Given I set API endpoint for all carts
    When I send request to get other user carts
    Then I receive status code 200
    And I receive valid data of other user carts

  Scenario: As a user, I can get carts by date range
    Given I set API endpoint for all carts
    When I send request to get carts by date range
    Then I receive status code 200
    And I receive valid data of all carts by date range

  Scenario: As a user, I can add new cart
    Given I set API endpoint for all carts
    When I send request to add new cart
    Then I receive status code 200
    And I receive valid data of new cart

  Scenario: As a user, I cannot add new cart with empty fields
    Given I set API endpoint for all carts
    When I send request to add new cart with empty fields
    Then I receive status code 400

  Scenario: As a user, I can update a cart
    Given I set API endpoint for all carts
    When I send request to update a cart
    Then I receive status code 200
    And I receive valid data of updated product

  Scenario: As a user, I cannot update cart with empty fields
    Given I set API endpoint for all carts
    When I send request to update cart with empty fields
    Then I receive status code 400

  Scenario: As a user, I can delete a cart
    Given I set API endpoint for all carts
    When I send request to delete a cart
    Then I receive status code 200




