Feature: Validate checkout flow on SwagLabs page
  Scenario: Validate checkout flow
    Given app is open
    When entering email standard_user and password secret_sauce
    And press login button
    And sort products from most expensive to cheapest
    And add product to the cart
    And add product to the cart
    And proceed with the checkout