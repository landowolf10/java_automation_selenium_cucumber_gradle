package project.steps_definition.common;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import framework.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static pages.LoginPage.loginButton;

public class CommonSteps extends BasePage
{
    @Given("app is open")
    public void validateAppOpen() {
        getElementBy(By.xpath(loginButton));
    }

    @After
    public void closeDriver() {
        killDriver();
    }

    @AfterStep
    public void screenShot(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) getWebDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Screenshot");
    }
}
