package framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static framework.config.Config.instanceExists;
import static framework.config.RunSettings.loadConfig;

public class Clients
{
    WebDriver driver;

    public WebDriver getDriver()
    {
        if (instanceExists)
            driver = Config.driver;
        else
            driver = createDriver();

        instanceExists = true;
        Config.driver = driver;

        return driver;
    }

    private WebDriver createDriver()
    {
        HashMap<String, String> runSettings = loadConfig();
        System.setProperty(runSettings.get("chromeDriver"), runSettings.get("driverPath"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

        driver.get(runSettings.get("URL"));
        driver.manage().window().maximize();

        return driver;
    }

    public void killDriver() {
        WebDriver currentDriver;

        if (instanceExists)
        {
            currentDriver = Config.driver;
            currentDriver.quit();
        }

        instanceExists = false;
        Config.driver = null;
    }
}