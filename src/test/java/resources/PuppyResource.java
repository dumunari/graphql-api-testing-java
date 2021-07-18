package resources;

import io.restassured.http.ContentType;
import resources.base.BaseResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class PuppyResource extends BaseResource {

    public void preparePuppiesQuery() {
        dogophql.setQuery(queryPuppies());

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void prepareCreatePuppyMutation(String puppyName, String puppyColor, String breedId, String firstParentId, String secondParentId) {
        dogophql.setQuery(createPuppyMutation(puppyName, puppyColor, breedId, firstParentId, secondParentId));

        request = given()
                    .contentType(ContentType.JSON)
                        .body(dogophql);
    }

    public void assertQueryPuppiesResponse() {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.puppies.name", hasItem(equalTo("Tyke")));
        }

    public void assertCreatePuppyMutationResponse(String puppyName) {
        response.then()
                    .assertThat()
                        .statusCode(200)
                            .and()
                            .body("data.createPuppy.name", equalTo(puppyName));
    }

    private String queryPuppies() {
        return "{ puppies { id name breed { name } parents { name breed { name } puppies { name } } } }";
    }

    private String createPuppyMutation(String name, String color, String breedId, String firstParentId, String secondParentId) {
        return String.format("mutation { createPuppy(input: { name: \"%s\", color: \"%s\", breedId: \"%s\", parentsId: [\"%s\", \"%s\"] }) { id name color } }", name, color, breedId, firstParentId, secondParentId);
    }
}
