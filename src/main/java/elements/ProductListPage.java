package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage {
    @FindBy(xpath = "//ol[contains(@class,'product-items')]/li")
    public static WebElement LIST_PRODUCTS;

    @FindBy(xpath = "//div[contains(@class,'toolbar-products')][2]/div[@class='field limiter']/div/select")
    public static WebElement SELECT_PAGES;

    @FindBy(xpath = "//div[contains(@class,'toolbar-products')][1]/div/select[@id='sorter']")
    public static WebElement SELECT_SORTER;

}
