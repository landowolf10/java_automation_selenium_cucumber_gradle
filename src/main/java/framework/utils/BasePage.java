package framework.utils;

import framework.config.Clients;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage extends Clients
{
    static WebDriver driver;

    public BasePage() {
        driver = getDriver();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static WebElement getElementBy(By elementLocator)
    {
        return getWebDriver().findElement(elementLocator);
    }

    public static List<WebElement> getElementsBy(By elementLocator)
    {
        return getWebDriver().findElements(elementLocator);
    }

    public static void setText(By elementLocator, String text)
    {
        getElementBy(elementLocator).clear();
        getElementBy(elementLocator).sendKeys(text);
    }

    public static void clickButton(By elementLocator, int waitAfterClick)
    {
        getElementBy(elementLocator).click();
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitAfterClick));
    }
    public void pressButtons(WebElement element)
    {
        element.click();
    }

    public String getElementAttribute(By elementLocator, String attribute)
    {
        return getDriver().findElement(elementLocator).getAttribute(attribute);
    }

    public String getElementText(By elementLocator)
    {
        return getWebDriver().findElement(elementLocator).getText();
    }

    public static boolean elementExists(By elementLocator, int maxWaitSec) {
        boolean elementDisplayed;

        try {
            elementDisplayed = waitUntilElementLocated(elementLocator, maxWaitSec).isDisplayed();
        }
        catch (TimeoutException e) {
            elementDisplayed = false;
        }

        return elementDisplayed;
    }

    public static WebElement waitUntilElementLocated(By locatorType, int maxWaitSec) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(locatorType), maxWaitSec);
    }

    private List<WebElement> waitUntilElementsLocated(WebElement elements) {
        return waitUntilElements(ExpectedConditions.visibilityOfAllElements(elements), 10);
    }

    private WebElement waitUntilClickable(By locatorType) {
        return waitUntil(ExpectedConditions.elementToBeClickable(locatorType), 10);
    }

    public static WebElement waitUntil(ExpectedCondition<WebElement> condition, int maxWaitSec) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(maxWaitSec));

        return wait.until(condition);
    }

    private List<WebElement> waitUntilElements(ExpectedCondition<List<WebElement>> condition, int maxWaitSec) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(maxWaitSec));


        return wait.until(condition);
    }
}
