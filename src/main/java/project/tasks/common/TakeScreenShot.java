package project.tasks.common;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static framework.utils.BasePage.getWebDriver;

public class TakeScreenShot
{
    public static void takeScreenShot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot) getWebDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}