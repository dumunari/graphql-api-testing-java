package step_definitions.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.DogophQL;

public abstract class BaseSteps {
    static protected DogophQL dogophql = new DogophQL();
    static protected Response response;
    static protected RequestSpecification request;
}
