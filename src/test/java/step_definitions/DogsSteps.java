package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import resources.DogResource;

public class DogsSteps {
    private final DogResource dogResource = new DogResource();

    @Given("user wants to add dog named {string}, with age {int} breedId {string}")
    public void userWantsToAddDogNamedWithAgeBreedId(String dogName, Integer dogAge, String breedId) {
        dogResource.prepareCreateDogsMutation(dogName, dogAge, breedId);
    }

    @Then("should return recently created dog {string}")
    public void shouldReturnRecentlyCreatedDog(String dogName) {
        dogResource.assertCreateDogMutationResponse(dogName);
    }

    @Given("user wants to search dogs")
    public void userWantsToSearchDogs() {
        dogResource.prepareDogsQuery();
    }

    @Then("should return all dogs")
    public void shouldReturnAllDogs() {
        dogResource.assertQueryDogsResponse();
    }

    @Given("user wants to add puppy with id {string} to parents with id {string} and {string}")
    public void userWantsToAddPuppyWithIdToParentsWithIdAnd(String puppyId, String firstParentId, String secondParentId) {
        dogResource.prepareAddPuppyToParentsMutation(puppyId, firstParentId, secondParentId);
    }

    @Then("should return parents id {string} and {string}")
    public void shouldReturnParentsIdAnd(String firstParentId, String secondParentId) {
        dogResource.assertAddPuppyToParentsResponseIds(firstParentId, secondParentId);
    }

    @Then("parents name {string} and {string}")
    public void parentsNameAnd(String firstParentName, String secondParentName) {
        dogResource.assertAddPuppyToParentsResponseNames(firstParentName, secondParentName);
    }

}
