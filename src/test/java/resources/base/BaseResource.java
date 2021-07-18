package resources.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api.schema.DogophQL;

public abstract class BaseResource {
    static protected Response response;
    static protected RequestSpecification request;
    static protected DogophQL dogophql = new DogophQL();
}
