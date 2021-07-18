@Breeds
Feature: Manage Breeds
  As an API user
  I want to be able to add new breeds and consult existing ones

  Scenario: Add a breed
    Given user wants to add "English bulldog" breed
    When dogophql api is called
    Then should return recently created breed "English bulldog"

  Scenario: Search breeds
    Given user wants to search breeds
    When dogophql api is called
    Then should return all breeds