package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInfoPage {
    @FindBy(xpath = "//h1[@class='page-title']/span")
    public static WebElement LABEL_PRODUCT_NAME;

    @FindBy(xpath = "//div[@class='product-info-price']/div[contains(@class, 'final_price')]/span[not(contains(@class, 'no-display'))]/span/span/span[@class='price']")
    public static WebElement LABEL_PRODUCT_PRICE;

    @FindBy(xpath = "//div[@class='fieldset']/div/div[contains(@class, 'size')]/div")
    public static WebElement LIST_SIZE;

    @FindBy(xpath = "//div[contains(@class, 'color')]/div")
    public static WebElement LIST_COLOR;

    @FindBy(name = "qty")
    public static WebElement INPUT_QUANTITY;

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    public static WebElement BUTTON_ADD_TO_CART;

}
