Feature: Product
  As a user
  I can manage products
  So that product can be better

  Scenario: As a user, I can get all product
    Given I set API endpoint for all product
    When I send request to get all product
    Then I receive status code 200
    And I receive valid data of all products

  Scenario: As a user, I can get a single product
    Given I set API endpoint for all product
    When I send request to get a single product
    Then I receive status code 200
    And I receive valid data that product

  Scenario: As a user, I can limits the result
    Given I set API endpoint for all product
    When I send request to limit the result
    Then I receive status code 200
    And I receive valid data of all products of limited result

  Scenario: As a user, I can sort products by descending
    Given I set API endpoint for all product
    When I send request to sort products by descending
    Then I receive status code 200
    And I receive valid data of all products by descending

  Scenario: As a user, I can sort products by ascending
    Given I set API endpoint for all product
    When I send request to sort products by ascending
    Then I receive status code 200
    And I receive valid data of all products by ascending

  Scenario: As a user, I can get all categories
    Given I set API endpoint for all category
    When I send request to get all categories
    Then I receive status code 200
    And I receive valid data of all categories

  Scenario: As a user, I can get in a specific category
    Given I set API endpoint for all category
    When I send request to get a specific category
    Then I receive status code 200
    And I receive valid data of a category

  Scenario: As a user, I can add new product
    Given I set API endpoint for all product
    When I send request to add new product
    Then I receive status code 200
    And I receive valid data of new product

  Scenario: As a user, I cannot add new product with empty fields
    Given I set API endpoint for all product
    When I send request to add new product with empty fields
    Then I receive status code 400

  Scenario: As a user, I can update a product
    Given I set API endpoint for all product
    When I send request to update a product
    Then I receive status code 200
    And I receive valid data of updated product

  Scenario: As a user, I cannot update product with empty fields
    Given I set API endpoint for all product
    When I send request to update product with empty fields
    Then I receive status code 400

  Scenario: As a user, I can delete a product
    Given I set API endpoint for all product
    When I send request to delete a product
    Then I receive status code 200