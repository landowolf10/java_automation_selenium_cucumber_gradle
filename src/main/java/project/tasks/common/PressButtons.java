package org.example.project.tasks.common;

import framework.utils.BasePage;
import org.openqa.selenium.WebElement;

public class PressButtons
{
    BasePage basePage = new BasePage();

    public void pressButtons(WebElement element)
    {
        basePage.pressButtons(element);
    }
}
