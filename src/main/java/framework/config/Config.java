package framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Config extends DesiredCapabilities
{
    public static WebDriver driver = null;
    public static boolean instanceExists = false;
}
