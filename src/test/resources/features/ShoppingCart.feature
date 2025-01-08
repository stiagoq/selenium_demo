Feature: Shopping Cart

  Scenario Outline: Add products in the shopping cart
    Given User is on the '<product>' List page
    When User select '<product>' and add it to the cart
    And User navigate to the shopping Cart page and add it to the cart
    And User enter the information in the payment form
    Then User should see the Thank you for your purchase message

    Examples:
    | product |
    | women   |
    | men     |