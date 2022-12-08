package org.example.project.tasks;

import framework.utils.BasePage;
import org.openqa.selenium.By;

public class SendCredentials extends BasePage
{
    public static void sendText(By elementLocator, String text)
    {
        setText(elementLocator, text);
    }
}
