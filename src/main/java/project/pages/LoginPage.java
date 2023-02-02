package project.pages;

import org.openqa.selenium.By;
import project.models.LoginModel;

import static framework.utils.BasePage.setText;
import static framework.utils.BasePage.waitUntilElementLocated;
import static project.locators.DashboardLocators.cartIcon;
import static project.locators.DashboardLocators.sortDropDown;
import static project.locators.LoginLocators.*;

public class LoginPage
{
    public static void login(String email, String password)
    {
        LoginModel loginModel = new LoginModel(
                email,
                password
        );

        setText(By.xpath(userTextbox), loginModel.getEmail());
        setText(By.xpath(passwordTextbox), loginModel.getPassword());
    }

    public static void validateSuccessfulLogin()
    {
        waitUntilElementLocated(By.xpath(cartIcon), 10);
        waitUntilElementLocated(By.xpath(sortDropDown), 10);
    }

    public static void validateInvalidLogin()
    {
        waitUntilElementLocated(By.xpath(loginButton), 10);
        waitUntilElementLocated(By.xpath(errorMessage), 10);
    }
}