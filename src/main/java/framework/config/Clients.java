package framework.config;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

import static framework.config.Config.chromeInstanceExists;
import static framework.config.Config.geckoInstanceExists;
import static framework.config.RunSettings.loadConfig;

public class Clients
{
    WebDriver chromeDriver, geckoDriver;

    public WebDriver getDriver()
    {
        if (chromeInstanceExists) {
            chromeDriver = Config.chromeDriver;
        }
        else {
            chromeDriver = createDriver().get("chrome");
        }

        if (geckoInstanceExists) {
            geckoDriver = Config.geckoDriver;
        }
        else {
            geckoDriver = createDriver().get("firefox");
        }

        chromeInstanceExists = true;
        geckoInstanceExists = true;
        Config.chromeDriver = chromeDriver;
        Config.geckoDriver = geckoDriver;

        return chromeDriver;
    }

    private HashMap<String, WebDriver> createDriver()
    {
        HashMap<String, String> runSettings = loadConfig();
        HashMap<String, WebDriver> webDriver = new HashMap<>();
        System.setProperty(runSettings.get("chromeDriver"), runSettings.get("driverPath"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);

        chromeDriver.get(runSettings.get("URL"));
        chromeDriver.manage().window().maximize();

        System.setProperty(runSettings.get("geckoDriver"), runSettings.get("driverPathGecko"));
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.addArguments("--headless");
        geckoDriver = new FirefoxDriver(firefoxOptions);

        geckoDriver.get(runSettings.get("URL"));
        geckoDriver.manage().window().maximize();

        webDriver.put("chrome", chromeDriver);
        webDriver.put("firefox", geckoDriver);

        return webDriver;
    }

    public void killDriver() {
        WebDriver currentChromeDriver, currentGeckoDriver;

        if (chromeInstanceExists)
        {
            currentChromeDriver = Config.chromeDriver;
            currentChromeDriver.quit();
        }

        if (geckoInstanceExists)
        {
           currentGeckoDriver = Config.geckoDriver;
           currentGeckoDriver.quit();
        }

        chromeInstanceExists = false;
        geckoInstanceExists = false;
        Config.chromeDriver = null;
        Config.geckoDriver = null;
    }
}