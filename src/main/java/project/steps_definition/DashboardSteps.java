package project.steps_definition;

import io.cucumber.java.en.And;
import project.pages.DashboardPage;

import static project.pages.DashboardPage.sortWithDropDown;

public class DashboardSteps
{
    DashboardPage dashboardPage = new DashboardPage();

    @And("sort products from most expensive to cheapest")
    public void sortProduct()
    {
        sortWithDropDown();
    }

    @And("add product to the cart")
    public void addProductToCart()
    {
        dashboardPage.addProduct();
    }
}