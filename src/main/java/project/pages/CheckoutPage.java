package project.pages;

import org.openqa.selenium.By;

import static framework.utils.BasePage.*;
import static project.locators.CheckoutLocators.*;
import static project.locators.DashboardLocators.*;
import static project.pages.DashboardPage.itemsSum;
import static project.tasks.common.PressButton.pressButton;

public class CheckoutPage
{
    public static void proceedWithCheckout()
    {
        pressButton(By.xpath(cartIcon), 5);
        pressButton(By.xpath(checkoutButton), 5);
        setText(By.xpath(txtFirstName), "Orlando");
        setText(By.xpath(txtLastName), "Avila");
        setText(By.xpath(txtZipCode), "40880");
        pressButton(By.xpath(continueButton), 10);
    }

    public static void validateSubtotal()
    {
        assert itemsSum().equals(getElementText(By.xpath(subtotal)));
    }

    public static void verifyCheckoutCompleted()
    {
        assert getElementText(By.xpath(orderTitle)).equals("THANK YOU FOR YOUR ORDER");
        assert getElementText(By.xpath(orderMessage)).equals("Your order has been dispatched, and will arrive " +
                "just as fast as the pony can get there!");
        waitUntilElementLocated(By.xpath(backToHomeButton), 10);
    }
}