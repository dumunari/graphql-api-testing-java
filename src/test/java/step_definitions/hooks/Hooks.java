package step_definitions.hooks;

import io.cucumber.java.Before;
import resources.base.BaseResource;

public class Hooks extends BaseResource {
    @Before
    public void prepare() {
        response = null;
        request = null;
    }
}
