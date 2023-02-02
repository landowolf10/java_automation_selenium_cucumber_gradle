package project.steps_definition;

import io.cucumber.java.en.And;
import framework.utils.BasePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static project.locators.CheckoutLocators.finishButton;
import static project.pages.CheckoutPage.*;
import static project.tasks.common.PressButton.pressButton;

public class CheckoutSteps extends BasePage
{

    @And("checkout information")
    public void checkoutInfo()
    {
        proceedWithCheckout();
        validateSubtotal();
        pressButton(By.xpath(finishButton), 10);
    }

    @Then("finish checkout")
    public void finishCheckout()
    {
        verifyCheckoutCompleted();
    }
}