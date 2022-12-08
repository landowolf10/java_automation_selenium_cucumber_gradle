package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/project/features/checkout.feature",
        glue = {"project/steps_definition"},
        plugin = {
                "pretty", "html:reports/html/report.html",
                "json:reports/json/reports.json"
        }
)

public class TestRunner
{
}
