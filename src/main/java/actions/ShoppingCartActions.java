package actions;

import elements.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActions {
    WebDriver driver;
    List<WebElement> labels;
    List<WebElement> prices;
    List<WebElement> listQuantities;
    List<WebElement> listSubTotals;
    List<String> nameAndPriceFirstProduct;

    public ShoppingCartActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ShoppingCartPage.class);
    }

    public List<String> listProductInShoppingCart(){
        labels = driver.findElements(By.xpath("//tbody[@class='cart item']/tr/td/div/strong[@class='product-item-name']/child::a"));
        prices = driver.findElements(By.xpath("//tbody[@class='cart item']/tr/td[@class='col price']/span/span/span"));
        nameAndPriceFirstProduct = new ArrayList<>();
        nameAndPriceFirstProduct.add(labels.get(0).getText() + "==" + prices.get(0).getText());
        nameAndPriceFirstProduct.add(labels.get(1).getText() + "==" + prices.get(1).getText());
        return nameAndPriceFirstProduct;
    }

    public void verifySubTotalCalculation() {
        listSubTotals = driver.findElements(By.xpath("//tbody[@class='cart item']/tr/td[@class='col subtotal']/span/span/span"));
        listQuantities = driver.findElements(By.xpath("//input[contains(@name, '[qty]')]"));
        float priceOne;
        float subTotalOne;
        priceOne = Math.round((Float.valueOf(nameAndPriceFirstProduct.get(0).split("==")[1].replace("$","")) * 100.00f) / 100.00f);
        subTotalOne = priceOne * Float.valueOf(listQuantities.get(0).getAttribute("value"));
        if (subTotalOne != Float.valueOf(listSubTotals.get(0).getText().replace("$",""))) {
            throw new AssertionError("The subtotal value does not match. Expected: " + subTotalOne + ", but found: " + Float.valueOf(listSubTotals.get(0).getText().replace("$","")));
        }

        float priceTwo;
        float subTotalTwo;
        priceTwo = Math.round((Float.valueOf(nameAndPriceFirstProduct.get(1).split("==")[1].replace("$","")) * 100.00f) / 100.00f);
        subTotalTwo = priceTwo * Float.valueOf(listQuantities.get(1).getAttribute("value"));
        if (subTotalTwo != Float.valueOf(listSubTotals.get(1).getText().replace("$",""))) {
            throw new AssertionError("The subtotal value does not match. Expected: " + subTotalOne + ", but found: " + Float.valueOf(listSubTotals.get(1).getText().replace("$","")));
        }
    }

    public void clickButtonContinue(){
        ShoppingCartPage.BUTTON_CHECKOUT.click();
    }
}


