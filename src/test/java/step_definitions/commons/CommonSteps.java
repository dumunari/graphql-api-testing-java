package step_definitions.commons;

import io.cucumber.java.en.When;
import step_definitions.base.BaseSteps;

public class CommonSteps extends BaseSteps {
    @When("dogophql api is called")
    public void dogophqlApiIsCalled() {
        response =
                request.when()
                            .post();
    }
}
