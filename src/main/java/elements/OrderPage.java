package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {
    /**********************************************************************************************************************/
    /*                                              Shipping                                                              */
    /**********************************************************************************************************************/

    @FindBy(xpath = "//div[@class='shipping-address-item selected-item']")
    public static WebElement CARD_ADDRESS;

    @FindBy(xpath = "//input[@name='company']")
    public static WebElement INPUT_COMPANY_NAME;

    @FindBy(xpath = "//input[@name='city']")
    public static WebElement INPUT_CITY_NAME;

    @FindBy(xpath = "//input[@name='telephone']")
    public static WebElement INPUT_TELEPHONE;

    @FindBy(xpath = "//input[@name='postcode']")
    public static WebElement INPUT_POSTCODE;

    @FindBy(xpath = "//div[contains(@name,'.region_id')]/div/select")
    public static WebElement SELECT_REGION;

    @FindBy(xpath = "//div[contains(@name,'.country_id')]/div/select")
    public static WebElement SELECT_COUNTRY;

    @FindBy(xpath = "//input[contains(@name,'unique')][1]")
    public static WebElement RADIO_BUTTON;

    @FindBy(xpath = "//button[contains(@class,'continue')]")
    public static WebElement BUTTON_CONTINUE;

    /**********************************************************************************************************************/
    /*                                              Review & Payments                                                     */
    /**********************************************************************************************************************/

    @FindBy(xpath = "//div[@class='title']/strong/span[contains(text(),'Items')]")
    public static WebElement LABEL_ITEMS_CART;

    @FindBy(xpath = "//ol[@class='minicart-items']/li/div/div[@class='product-item-details']/div[@class='product-item-inner']")
    public static WebElement LIST_PRODUCTS_CART;

    @FindBy(xpath = "//button[contains(@class,'checkout')]")
    public static WebElement BUTTON_CHECKOUT;

    /**********************************************************************************************************************/
    /*                                              Your purchase                                                         */
    /**********************************************************************************************************************/

    @FindBy(xpath = "//h1/span[@class='base' and contains(text(),'Thank you')]")
    public static WebElement LABEL_MESSAGE_CHECKOUT;

    @FindBy(xpath = "//div[@class='checkout-success']/p[contains(text(),'Your order')]")
    public static WebElement LABEL_MESSAGE_ORDER_PLACED;

    @FindBy(xpath = "//div[@class='checkout-success']/p[contains(text(),'Your order')]/a/strong")
    public static WebElement LINK_ORDER_NUMBER;
}
