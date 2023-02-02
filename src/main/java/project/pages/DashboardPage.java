package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import project.tasks.common.PressButtons;

import java.util.ArrayList;
import java.util.List;

import static framework.utils.BasePage.*;
import static project.locators.DashboardLocators.*;

public class DashboardPage
{
    public static void sortWithDropDown()
    {
        Select sort = new Select(getElementBy(By.xpath(sortDropDown)));
        sort.selectByVisibleText("Price (high to low)");
    }

    PressButtons pressButtons = new PressButtons();

    private List<Float> getPrices()
    {
        int elements = getElementsBy(By.xpath(productPrice)).size();
        List<Float> prices = new ArrayList<>();

        for (int i = 0; i < elements; i++)
            prices.add(Float.valueOf(getElementsBy(By.xpath(productPrice)).
                    get(i).getText().substring(1)));

        return prices;
    }

    static List<Float> selectedItemPrices = new ArrayList<>();
    public void addProduct()
    {
        List<WebElement> webElements = getElementsBy(By.xpath(addToCartButton));
        List<Float> prices = getPrices();

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < 20)
            {
                //clickButton(By.xpath(webElements.get(i)), 10);
                pressButtons.pressButtons(webElements.get(i));
                prices.remove(i);
                webElements.remove(i);
                selectedItemPrices.add(prices.get(i));

                break;
            }
        }
    }

    public static String itemsSum()
    {
        float sum = 0;

        for (Float selectedItemPrice : selectedItemPrices) sum += selectedItemPrice;

        return "Item total: $" + sum;
    }
}