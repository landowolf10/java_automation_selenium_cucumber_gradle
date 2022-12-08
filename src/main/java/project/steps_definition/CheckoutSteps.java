package project.steps_definition;

import io.cucumber.java.en.And;
import framework.utils.BasePage;
import org.openqa.selenium.By;

import static pages.CheckoutPage.*;
import static org.example.project.tasks.SendCredentials.sendText;
import static project.pages.MainPage.cartIcon;
import static project.tasks.common.PressButton.pressButton;

public class CheckoutSteps extends BasePage
{
    @And("proceed with the checkout")
    public void addProductToCart()
    {
        pressButton(By.xpath(cartIcon), 5);
        pressButton(By.xpath(checkoutButton), 5);
        sendText(By.xpath(txtFirstName), "Orlando");
        sendText(By.xpath(txtLastName), "Avila");
        sendText(By.xpath(txtZipCode), "40880");
    }
}
