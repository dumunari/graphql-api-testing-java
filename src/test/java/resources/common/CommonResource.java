package resources.common;

import resources.base.BaseResource;

public class CommonResource extends BaseResource {
    public void callDogophQLApi() {
        response = request
                    .when()
                        .post();
    }
}
