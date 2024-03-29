package runners.individual_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/project/features/checkout/checkout.feature",
        glue = {"project/steps_definition"},
        plugin = {
                "pretty", "html:src/main/java/project/reports/html/report.html",
                "json:src/main/java/project/reports/json/report.json"
        },
        publish = true
)

public class CheckoutRunner
{
}
