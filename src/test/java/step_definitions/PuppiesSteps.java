package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import models.Puppy;
import step_definitions.base.BaseSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class PuppiesSteps extends BaseSteps {
    private final Puppy puppy = new Puppy();

    @Given("user wants to add puppy named {string}, with color {string} and breedId {string} parents with id {string} and {string}")
    public void userWantsToAddPuppyNamedWithColorAndBreedIdParentsWithIdAnd(String puppyName, String puppyColor, String breedId, String firstParentId, String secondParentId) {
        dogophql.setQuery(puppy.createPuppiesMutation(puppyName, puppyColor, breedId, firstParentId, secondParentId));

        request = given()
                    .contentType(ContentType.JSON)
                    .body(dogophql);
    }

    @Then("should return recently created puppy {string}")
    public void shouldReturnRecentlyCreatedPuppy(String puppyName) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.createPuppy.name", equalTo(puppyName));
    }

    @Given("user wants to search puppies")
    public void userWantsToSearchPuppies() {
        dogophql.setQuery(puppy.queryPuppies());

        request = given()
                    .contentType(ContentType.JSON)
                    .body(dogophql);
    }

    @Then("should return all puppies")
    public void shouldReturnAllPuppies() {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.puppies.name", hasItem(equalTo("Tyke")));
    }
}
