@Dogs
Feature: Manage Dogs
  As an API user
  I want to be able to add new dogs, consult existing ones and add puppy to parents

  Scenario: Add a dog
    Given user wants to add dog named "Kelevra", with age 1 breedId "T5577006791947779410"
    When dogophql api is called
    Then should return recently created dog "Kelevra"

  Scenario: Search dogs
    Given user wants to search dogs
    When dogophql api is called
    Then should return all dogs

  @Puppies
  Scenario: Add puppy to parents
    Given user wants to add puppy with id "T4751997750760398084" to parents with id "T6129484611666145821" and "T2775422040480279449"
    When dogophql api is called
    Then should return parents id "T6129484611666145821" and "T2775422040480279449"
    And parents name "Spike" and "Spika"