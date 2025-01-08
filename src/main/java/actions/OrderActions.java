package actions;

import elements.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.others.WaitingTimes;
import utils.randomdata.RandomData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrderActions {
    WebDriver driver;
    WaitingTimes waitingTimes = new WaitingTimes();
    Wait<WebDriver> wait;
    List<WebElement> inputsStreetAddress;
    List<WebElement> regions;
    List<WebElement> countries;
    List<WebElement> nameProducts;
    List<WebElement> quantityProducts;
    List<WebElement> cardAdreesses;
    List<String> nameAndQuantityFirstProduct;

    Select select;

    public OrderActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, OrderPage.class);
    }

    /**********************************************************************************************************************/
    /*                                              Shipping                                                              */
    /**********************************************************************************************************************/

    public void entersData() {
        cardAdreesses = driver.findElements(By.xpath("//div[@class='new-address-popup']/button/span"));
        if(!cardAdreesses.isEmpty()){
            waitingTimes.waitForOneSecond();
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(d -> OrderPage.BUTTON_CONTINUE.isEnabled());
            OrderPage.BUTTON_CONTINUE.click();
        }else {
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(d -> OrderPage.BUTTON_CONTINUE.isEnabled());
            inputsStreetAddress = driver.findElements(By.xpath("//fieldset[contains(@class,'street')]/div/div/div/input"));
            regions = driver.findElements(By.xpath("//div[contains(@name,'.region_id')]/div/select/option"));
            regions = OrderPage.SELECT_REGION.findElements(By.xpath("child::option"));
            countries = OrderPage.SELECT_COUNTRY.findElements(By.xpath("child::option"));
            WebElement optionRegion = regions.get(RandomData.getRandomNumber(0,regions.size()));
            WebElement optionCountry = countries.get(RandomData.getRandomNumber(0,regions.size()));
            select = new Select(OrderPage.SELECT_REGION);
            select.selectByValue(optionRegion.getAttribute("value"));
            select = new Select(OrderPage.SELECT_COUNTRY);
            select.selectByValue(optionCountry.getAttribute("value"));
            for(int i = 0; i < inputsStreetAddress.size(); i++){
                inputsStreetAddress.get(i).sendKeys(RandomData.getRandomText("Street "));
            }
            OrderPage.INPUT_COMPANY_NAME.sendKeys(RandomData.getRandomText("Company "));
            OrderPage.INPUT_CITY_NAME.sendKeys(RandomData.getRandomText("City "));
            OrderPage.INPUT_TELEPHONE.sendKeys(RandomData.getRandomNumberForInputs());
            OrderPage.INPUT_POSTCODE.sendKeys("50012");
            waitingTimes.waitForThreeSecond();
            OrderPage.BUTTON_CONTINUE.click();
        }
    }

    public void clickViewSummaryProducts() {
        waitingTimes.waitForFiveSecond();
        OrderPage.LABEL_ITEMS_CART.click();
    }

    /**********************************************************************************************************************/
    /*                                              Review & Payments                                                     */
    /**********************************************************************************************************************/

    public List<String> returnInfoProductInCheckout() {
        nameProducts = driver.findElements(By.xpath("//ol[@class='minicart-items']/li/div/div[@class='product-item-details']/div[@class='product-item-inner']/child::div/strong"));
        quantityProducts = driver.findElements(By.xpath("//ol[@class='minicart-items']/li/div/div[@class='product-item-details']/div[@class='product-item-inner']/child::div/div/span[@class='value']"));
        nameAndQuantityFirstProduct = new ArrayList<>();
        nameAndQuantityFirstProduct.add(nameProducts.get(0).getText() + "==" + quantityProducts.get(0).getText());
        nameAndQuantityFirstProduct.add(nameProducts.get(1).getText() + "==" + quantityProducts.get(1).getText());
        return nameAndQuantityFirstProduct;
    }

    public void clickCheckout() {
        OrderPage.BUTTON_CHECKOUT.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> OrderPage.LABEL_MESSAGE_CHECKOUT.isEnabled());
    }
}
