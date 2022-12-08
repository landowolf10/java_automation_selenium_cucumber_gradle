package org.example.project.tasks;

import framework.utils.BasePage;
import org.example.project.tasks.common.PressButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static project.pages.MainPage.addToCartButton;
import static project.pages.MainPage.productPrice;

public class GetProductPrices extends BasePage
{
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

    public void addProduct()
    {
        List<WebElement> webElements = getElementsBy(By.xpath(addToCartButton));
        List<Float> prices = getPrices();

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < 20)
            {
                pressButtons.pressButtons(webElements.get(i));
                prices.remove(i);
                webElements.remove(i);

                break;
            }
        }
    }
}
