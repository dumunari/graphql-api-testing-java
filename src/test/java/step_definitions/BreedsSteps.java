package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import models.Breed;
import step_definitions.base.BaseSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class BreedsSteps extends BaseSteps {

    private final Breed breed = new Breed();

    @Given("user wants to search breeds")
    public void userWantsToSearchBreeds() {
        dogophql.setQuery(breed.queryBreeds());

        request = given()
                    .contentType(ContentType.JSON)
                    .body(dogophql);
    }

    @Then("should return all breeds")
    public void shouldReturnAllBreeds() {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.breeds.name", hasItem(equalTo("English bulldog")));
    }

    @Given("user wants to add {string} breed")
    public void userWantsToAddBreed(String breedName) {
        dogophql.setQuery(breed.createBreedMutation(breedName));

        request = given()
                .contentType(ContentType.JSON)
                .body(dogophql);
    }

    @Then("should return recently created breed {string}")
    public void shouldReturnRecentlyCreatedBreed(String breedname) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.createBreed.name", equalTo(breedname));
    }
}
