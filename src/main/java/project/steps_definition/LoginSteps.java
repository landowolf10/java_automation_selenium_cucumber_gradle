package project.steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import framework.utils.BasePage;
import project.models.LoginModel;
import org.openqa.selenium.By;

import static pages.LoginPage.*;
import static org.example.project.tasks.SendCredentials.sendText;
import static project.tasks.common.PressButton.pressButton;

public class LoginSteps extends BasePage
{
    @When("entering email (.*) and password (.*)$")
    public void sendUsername(String email, String password)
    {
        LoginModel loginModel = new LoginModel(
                email,
                password
        );

        sendText(By.xpath(userTextbox), loginModel.getEmail());
        sendText(By.xpath(passwordTextbox), loginModel.getPassword());
    }

    @And("press login button")
    public void pressLoginButton()
    {
        pressButton(By.xpath(loginButton), 15);
    }
}
