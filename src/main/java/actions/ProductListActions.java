package actions;

import elements.ProductListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.others.WaitingTimes;
import utils.randomdata.RandomData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductListActions {
    Wait<WebDriver> wait;
    WebDriver driver;
    Actions actions;
    WaitingTimes waitingTimes = new WaitingTimes();
    Select select;
    List<WebElement> sorterOptions;
    List<WebElement> products;
    WebElement linkProduct;
    WebElement priceProduct;

    public ProductListActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ProductListPage.class);
    }

    public void selectSorterAndPage(){wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> ProductListPage.SELECT_PAGES.isDisplayed());
        actions = new Actions(driver);
        int deltaY = ProductListPage.SELECT_PAGES.getRect().y;
        actions.scrollByAmount(0, deltaY);
        select = new Select(ProductListPage.SELECT_PAGES);
        select.selectByValue("24");
        sorterOptions = ProductListPage.SELECT_SORTER.findElements(By.xpath("child::option"));
        WebElement option = sorterOptions.get(RandomData.getRandomNumber(0,sorterOptions.size()));
        select = new Select(ProductListPage.SELECT_SORTER);
        select.selectByValue(option.getAttribute("value"));
    }

    public List<String> returnInfoOfSelectedProduct(){
        waitingTimes.waitForOneSecond();
        //ol[contains(@class,'product-items')]/li
        products = driver.findElements(By.xpath("//ol[contains(@class,'product-items')]/li"));
        int randomProduct = RandomData.getRandomNumber(0, products.size());
        linkProduct = products.get(randomProduct).findElement(By.xpath("child::div/div/strong/a"));
        priceProduct = products.get(randomProduct).findElement(By.xpath("child::div/div/div/span/span/span/span[@class='price']"));
        List<String> infoProduct = new ArrayList<>();
        infoProduct.add(linkProduct.getText());
        infoProduct.add(priceProduct.getText());
        return infoProduct;
    }

    public void selectProduct(){
        linkProduct.click();
    }


}

