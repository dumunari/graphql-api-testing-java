@Puppies
Feature: Manage Puppies
  As an API user
  I want to be able to add new puppies and consult existing ones

  Scenario: Add a puppy
    Given user wants to add puppy named "Entei", with color "Brown" and breedId "T5577006791947779410" parents with id "T6129484611666145821" and "T2775422040480279449"
    When dogophql api is called
    Then should return recently created puppy "Entei"

  Scenario: Search puppies
    Given user wants to search puppies
    When dogophql api is called
    Then should return all puppies

