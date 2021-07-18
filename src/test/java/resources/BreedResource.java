package resources;

import io.restassured.http.ContentType;
import resources.base.BaseResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class BreedResource extends BaseResource {

    public void prepareBreedsQuery() {
        dogophql.setQuery(queryBreeds());

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void prepareCreateBreedMutation(String breedName) {
        dogophql.setQuery(createBreedMutation(breedName));

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void assertQueryBreedsResponse() {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.breeds.name", hasItem(equalTo("English bulldog")));
    }

    public void assertCreateBreedMutationResponse(String breedName) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.createBreed.name", equalTo(breedName));
    }

    private String queryBreeds() {
        return "{ breeds { id name } }";
    }

    private String createBreedMutation(String breedName) {
        return String.format("mutation { createBreed ( input: { name: \"%s\" }) { id name } }", breedName);
    }
}
