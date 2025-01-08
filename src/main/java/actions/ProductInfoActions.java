package actions;

import elements.ProductInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.others.WaitingTimes;
import utils.randomdata.RandomData;

import java.util.List;

public class ProductInfoActions {
    WaitingTimes waitingTimes = new WaitingTimes();
    WebDriver driver;
    List<WebElement> sizes;
    List<WebElement> colors;

    public ProductInfoActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ProductInfoPage.class);
    }

    public void selectSize(){
        sizes = ProductInfoPage.LIST_SIZE.findElements(By.xpath("child::div"));
        sizes.get(RandomData.getRandomNumber(0, sizes.size())).click();
    }

    public void selectColor(){
        colors = ProductInfoPage.LIST_COLOR.findElements(By.xpath("child::div"));
        colors.get(RandomData.getRandomNumber(0, colors.size())).click();
    }

    public void enterQuantity(){
        ProductInfoPage.INPUT_QUANTITY.clear();
        ProductInfoPage.INPUT_QUANTITY.sendKeys(String.valueOf(RandomData.getRandomNumber(1,4)));
    }

    public void addToCart(){
        waitingTimes.waitForOneSecond();
        ProductInfoPage.BUTTON_ADD_TO_CART.click();
    }
}
