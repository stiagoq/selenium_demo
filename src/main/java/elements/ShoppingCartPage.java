package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {
    @FindBy(xpath = "//tbody[@class='cart item']/tr/td/div/strong[@class='product-item-name']")
    public static WebElement LIST_LABEL_PRODUCT_NAME;

    @FindBy(xpath = "//tbody[@class='cart item']/tr/td[@class='col price']/span/span/span")
    public static WebElement LIST_LABEL_PRODUCT_PRICE;

    @FindBy(xpath = "//tbody[@class='cart item']/tr/td[@class='col subtotal']/span/span/span")
    public static WebElement LIST_LABEL_SUBTOTAL;

    @FindBy(xpath = "//table[@class='data table totals']/tbody/tr/td/strong/span")
    public static WebElement LABEL_TOTAL_PRICE;

    @FindBy(xpath = "//div[contains(@class, 'cart-summary')]/ul/li/button")
    public static WebElement BUTTON_CHECKOUT;

    @FindBy(xpath = "//input[contains(@name, '[qty]')]")
    public static WebElement INPUT_QUANTITY;
}
