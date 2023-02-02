package project.steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import framework.utils.BasePage;
import org.openqa.selenium.By;

import static project.locators.LoginLocators.loginButton;
import static project.pages.LoginPage.*;
import static project.tasks.common.PressButton.pressButton;

public class LoginSteps extends BasePage
{
    @When("entering email (.*) and password (.*)$")
    public void setUserCredentials(String email, String password)
    {
        login(email, password);
    }

    @And("press login button")
    public void pressLoginButton()
    {
        pressButton(By.xpath(loginButton), 15);
    }

    @Then("verify user successfully logged in")
    public void successfulLogin()
    {
        validateSuccessfulLogin();
    }

    @Then("verify user login was not successful")
    public void invalidLogin()
    {
        validateInvalidLogin();
    }
}