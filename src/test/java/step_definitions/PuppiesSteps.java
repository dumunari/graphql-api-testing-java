package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import resources.PuppyResource;

public class PuppiesSteps {
    private final PuppyResource puppyResource = new PuppyResource();

    @Given("user wants to add puppy named {string}, with color {string} and breedId {string} parents with id {string} and {string}")
    public void userWantsToAddPuppyNamedWithColorAndBreedIdParentsWithIdAnd(String puppyName, String puppyColor, String breedId, String firstParentId, String secondParentId) {
        puppyResource.prepareCreatePuppyMutation(puppyName, puppyColor, breedId, firstParentId, secondParentId);
    }

    @Then("should return recently created puppy {string}")
    public void shouldReturnRecentlyCreatedPuppy(String puppyName) {
        puppyResource.assertCreatePuppyMutationResponse(puppyName);
    }

    @Given("user wants to search puppies")
    public void userWantsToSearchPuppies() {
        puppyResource.preparePuppiesQuery();
    }

    @Then("should return all puppies")
    public void shouldReturnAllPuppies() {
        puppyResource.assertQueryPuppiesResponse();
    }
}
