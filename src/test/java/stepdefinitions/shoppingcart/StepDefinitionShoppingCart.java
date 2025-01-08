package stepdefinitions.shoppingcart;

import elements.OrderPage;
import elements.ProductInfoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import actions.*;
import utils.constants.AssertsOfTestCases;
import utils.hooks.Context;
import utils.others.WaitingTimes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitionShoppingCart {
    Context context;
    LoginActions loginActions;
    WebDriver driver;
    SoftAssert softAssert;
    WaitingTimes waitingTimes = new WaitingTimes();
    HomePageActions homePageActions;
    ProductListActions productListActions;
    ProductInfoActions productInfoActions;
    ShoppingCartActions shoppingCartActions;
    OrderActions orderActions;
    List<String> infoSelectedProduct;
    List<String> infoSelectedProductTwo;
    List<String> infoProductInShoppingCart;
    List<String> infoProductInCheckoutOrder;

    public StepDefinitionShoppingCart(Context context ) {
        this.context = context;
    }

    @Before
    public void setup() {
        softAssert = new SoftAssert();
        driver = context.getDriver();
        context.getLoginAndLogin();
        homePageActions = new HomePageActions(driver);
        productListActions = new ProductListActions(driver);
        productInfoActions = new ProductInfoActions(driver);
        shoppingCartActions = new ShoppingCartActions(driver);
        orderActions = new  OrderActions(driver);
    }

    @After
    public void tearDown() {
        context.tearDown();
    }

    @Given("User is on the {string} List page")
    public void userIsOnTheListPage(String string) {
        homePageActions.goToProductList(string);
    }

    @When("User select {string} and add it to the cart")
    public void userSelectAndAddItToTheCart(String string) {
        productListActions.selectSorterAndPage();
        infoSelectedProduct = productListActions.returnInfoOfSelectedProduct();
        productListActions.selectProduct();
        softAssert.assertEquals(ProductInfoPage.LABEL_PRODUCT_NAME.getText(),infoSelectedProduct.get(0));
        softAssert.assertEquals(ProductInfoPage.LABEL_PRODUCT_PRICE.getText(), infoSelectedProduct.get(1));
        softAssert.assertAll();
        productInfoActions.selectSize();
        productInfoActions.selectColor();
        productInfoActions.enterQuantity();
        productInfoActions.addToCart();

        homePageActions.goToProductList(string);
        infoSelectedProductTwo = productListActions.returnInfoOfSelectedProduct();
        productListActions.selectProduct();
        softAssert.assertEquals(ProductInfoPage.LABEL_PRODUCT_NAME.getText(),infoSelectedProductTwo.get(0));
        softAssert.assertEquals(ProductInfoPage.LABEL_PRODUCT_PRICE.getText(), infoSelectedProductTwo.get(1));
        softAssert.assertAll();
        productInfoActions.selectSize();
        productInfoActions.selectColor();
        productInfoActions.enterQuantity();
        productInfoActions.addToCart();
        homePageActions.goToCart();
    }

    @And("User navigate to the shopping Cart page and add it to the cart")
    public void userNavigateToTheShoppingCartPageAndAddItToTheCart() {
        infoProductInShoppingCart = shoppingCartActions.listProductInShoppingCart();
        softAssert.assertEquals(infoProductInShoppingCart.getFirst().split("==")[0], infoSelectedProduct.getFirst());
        softAssert.assertEquals(infoProductInShoppingCart.getLast().split("==")[0], infoSelectedProduct.getLast());
//        shoppingCartActions.verifySubTotalCalculation();
        shoppingCartActions.clickButtonContinue();
    }

    @And("User enter the information in the payment form")
    public void userEnterTheInformationInThePaymentForm() {
        orderActions.entersData();
    }

    @Then("User should see the Thank you for your purchase message")
    public void userShouldSeeTheThankYouForYourPurchaseMessage() {
        orderActions.clickViewSummaryProducts();
        infoProductInCheckoutOrder = orderActions.returnInfoProductInCheckout();
        assertEquals(infoProductInCheckoutOrder.getFirst().split("==")[0], infoSelectedProduct.getFirst());
        assertEquals(infoProductInCheckoutOrder.getLast().split("==")[0], infoSelectedProductTwo.getFirst());
        orderActions.clickCheckout();
        assertEquals(OrderPage.LABEL_MESSAGE_CHECKOUT.getText(), AssertsOfTestCases.EXPECTED_SUCCESS_MESSAGE_CHECKOUT);
        assertTrue(OrderPage.LABEL_MESSAGE_ORDER_PLACED.getText().contains(AssertsOfTestCases.EXPECTED_MESSAGE_ORDER_PLACED_CHECKOUT));
    }
}
