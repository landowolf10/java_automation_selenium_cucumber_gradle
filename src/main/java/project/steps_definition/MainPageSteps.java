package project.steps_definition;

import io.cucumber.java.en.And;
import org.example.project.tasks.GetProductPrices;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static framework.utils.BasePage.getElementBy;
import static project.pages.MainPage.sortDropDown;

public class MainPageSteps
{
    GetProductPrices productPrices = new GetProductPrices();

    @And("sort products from most expensive to cheapest")
    public void sortProduct()
    {
        Select sort = new Select(getElementBy(By.xpath(sortDropDown)));
        sort.selectByVisibleText("Price (high to low)");
    }

    @And("add product to the cart")
    public void addProductToCart()
    {
        productPrices.addProduct();
    }
}
