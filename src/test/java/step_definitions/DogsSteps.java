package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import models.Dog;
import step_definitions.base.BaseSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class DogsSteps extends BaseSteps {
    private final Dog dog = new Dog();

    @Given("user wants to add dog named {string}, with age {int} breedId {string}")
    public void userWantsToAddDogNamedWithAgeBreedId(String dogName, Integer dogAge, String breedId) {
        dogophql.setQuery(dog.createDogsMutation(dogName, dogAge, breedId));

        request = given()
                .contentType(ContentType.JSON)
                .body(dogophql);
    }

    @Then("should return recently created dog {string}")
    public void shouldReturnRecentlyCreatedDog(String dogName) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.createDog.name", equalTo(dogName));
    }


    @Given("user wants to search dogs")
    public void userWantsToSearchDogs() {
        dogophql.setQuery(dog.queryDogs());

        request = given()
                    .contentType(ContentType.JSON)
                    .body(dogophql);
    }

    @Then("should return all dogs")
    public void shouldReturnAllDogs() {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.dogs.name", hasItems(equalTo("Spike"), equalTo("Spika")))
                        .and()
                        .body("data.dogs.breed.name", hasItem(equalTo("English bulldog")));
    }

    @Given("user wants to add puppy with id {string} to parents with id {string} and {string}")
    public void userWantsToAddPuppyWithIdToParentsWithIdAnd(String puppyId, String firstParentId, String secondParentId) {
        dogophql.setQuery(dog.addPuppyToParentsMutation(puppyId, firstParentId, secondParentId));

        request = given()
                    .contentType(ContentType.JSON)
                    .body(dogophql);
    }

    @Then("should return parents id {string} and {string}")
    public void shouldReturnParentsIdAnd(String firstParentId, String secondParentId) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                        .and()
                        .body("data.addPuppyToParents.id", hasItems(equalTo(firstParentId), equalTo(secondParentId)));
    }

    @Then("parents name {string} and {string}")
    public void parentsNameAnd(String firstParentName, String secondParentName) {
        response.then()
                    .body("data.addPuppyToParents.name", hasItems(equalTo(firstParentName), equalTo(secondParentName)));
    }

}
