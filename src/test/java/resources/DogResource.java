package resources;

import io.restassured.http.ContentType;
import resources.base.BaseResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class DogResource extends BaseResource {

    public void prepareDogsQuery() {
        dogophql.setQuery(queryDogs());

        request = given()
                .contentType(ContentType.JSON)
                .body(dogophql);
    }

    public void prepareCreateDogsMutation(String dogName, Integer dogAge, String breedId) {
        dogophql.setQuery(createDogMutation(dogName, dogAge, breedId));

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void prepareAddPuppyToParentsMutation(String puppyId, String firstParentId, String secondParentId){
        dogophql.setQuery(addPuppyToParentsMutation(puppyId, firstParentId, secondParentId));

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void assertQueryDogsResponse(){
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.dogs.name", hasItems(equalTo("Spike"), equalTo("Spika")))
                                .and()
                                .body("data.dogs.breed.name", hasItem(equalTo("English bulldog")));
    }

    public void assertCreateDogMutationResponse(String dogName) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.createDog.name", equalTo(dogName));
    }

    public void assertAddPuppyToParentsResponseIds(String firstParentId, String secondParentId) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.addPuppyToParents.id", hasItems(equalTo(firstParentId), equalTo(secondParentId)));
    }

    public void assertAddPuppyToParentsResponseNames(String firstParentName, String secondParentName) {
        response.then()
                    .body("data.addPuppyToParents.name", hasItems(equalTo(firstParentName), equalTo(secondParentName)));
    }

    private String queryDogs() {
        return "{ dogs { id name age breed { name } puppies { name } } }";
    }

    private String createDogMutation(String name, int age, String breedId) {
        return String.format("mutation { createDog(input: { name: \"%s\" age: %d, breedId: \"%s\" }) { name age } }", name, age, breedId);
    }

    private String addPuppyToParentsMutation(String puppyId, String firstParentId, String secondParentId) {
        return String.format("mutation { addPuppyToParents(input: { puppyId: \"%s\" " +
                "parentsId: [\"%s\", \"%s\"], }) { id name } }", puppyId, firstParentId, secondParentId);
    }
}
