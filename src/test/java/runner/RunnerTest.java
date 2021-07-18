package runner;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = "step_definitions",
        plugin = {"pretty", "html:src/test/resources/reports/report.html", "json:src/test/resources/reports/report.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false
)
public class RunnerTest {
    @BeforeClass
    public static void setup(){
        Dotenv dotenv = Dotenv.load();

        RestAssured.baseURI = dotenv.get("DOGOPHQL_URI", "http://localhost:8080");
        RestAssured.basePath = dotenv.get("DOGOPHQL_PATH", "/dogophql");
    }
}
