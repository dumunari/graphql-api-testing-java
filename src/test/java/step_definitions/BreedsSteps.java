package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import resources.BreedResource;

public class BreedsSteps {

    private final BreedResource breedResource = new BreedResource();

    @Given("user wants to search breeds")
    public void userWantsToSearchBreeds() {
        breedResource.prepareBreedsQuery();
    }

    @Then("should return all breeds")
    public void shouldReturnAllBreeds() {
        breedResource.assertQueryBreedsResponse();
    }

    @Given("user wants to add {string} breed")
    public void userWantsToAddBreed(String breedName) {
        breedResource.prepareCreateBreedMutation(breedName);
    }

    @Then("should return recently created breed {string}")
    public void shouldReturnRecentlyCreatedBreed(String breedName) {
        breedResource.assertCreateBreedMutationResponse(breedName);
    }
}
