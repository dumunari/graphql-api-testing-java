package step_definitions.hooks;

import io.cucumber.java.Before;
import step_definitions.base.BaseSteps;

public class Hooks extends BaseSteps {
    @Before
    public void prepare() {
        response = null;
        request = null;
    }
}
