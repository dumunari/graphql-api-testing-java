package step_definitions.commons;

import io.cucumber.java.en.When;
import resources.base.BaseResource;
import resources.common.CommonResource;

public class CommonSteps extends BaseResource {

    CommonResource commonResource = new CommonResource();

    @When("dogophql api is called")
    public void dogophqlApiIsCalled() {
        commonResource.callDogophQLApi();
    }
}
