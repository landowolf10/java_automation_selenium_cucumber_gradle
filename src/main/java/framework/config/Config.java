package framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Config extends DesiredCapabilities
{
    public static WebDriver chromeDriver = null;
    public static WebDriver geckoDriver = null;
    public static boolean chromeInstanceExists = false;
    public static boolean geckoInstanceExists = false;
}