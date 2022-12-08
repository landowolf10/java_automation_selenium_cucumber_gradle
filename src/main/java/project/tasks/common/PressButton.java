package project.tasks.common;

import framework.utils.BasePage;
import org.openqa.selenium.By;

public class PressButton extends BasePage
{

    public static void pressButton(By elementLocator, int waitAfterClick)
    {
        clickButton(elementLocator, waitAfterClick);
    }
}
