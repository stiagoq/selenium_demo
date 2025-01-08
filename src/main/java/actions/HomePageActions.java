package actions;

import elements.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.others.WaitingTimes;
import utils.randomdata.RandomData;


import java.time.Duration;
import java.util.List;

public class HomePageActions {
    WebDriver driver;
    WaitingTimes waitingTimes = new WaitingTimes();
    Wait<WebDriver> wait;
    Actions actions;
    List<WebElement> topsOrButtomsWomen;
    List<WebElement> listTopsWomen;
    List<WebElement> listBottomsWomen;
    List<WebElement> topsOrButtomsMen;
    List<WebElement> listTopsMen;
    List<WebElement> listBottomsMen;

    public HomePageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, HomePage.class);
    }

    public void clickOnCreateAccount(){
        HomePage.BUTTON_CREATE_ACCOUNT.click();
    }

    public void openLoginPage(){
        HomePage.BUTTON_SIGN_IN.click();
    }

    public  String [] splitWelcomeMessage (){
        String welcomeInfo = HomePage.LABEL_WELCOME_MESSAGE.getText().replace("!","");
        return welcomeInfo.split("\\s");
    }

    public void waitElementVisible(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());
    }

    public void goToProductList(String user){
        waitingTimes.waitForOneSecond();
        actions = new Actions(driver);
        if(user.equals("women")){
            actions.moveToElement(HomePage.LINK_WOMEN).perform();
            topsOrButtomsWomen = HomePage.LINK_WOMEN.findElements(By.xpath("child::ul/li/a"));
            listTopsWomen = HomePage.LINK_TOPS_WOMEN.findElements(By.xpath("child::ul/li/a"));
            listBottomsWomen = HomePage.LINK_BOTTOMS_WOMEN.findElements(By.xpath("child::ul/li/a"));

            int randomNumberWomen = RandomData.getRandomNumber(0,topsOrButtomsWomen.size());
            actions.moveToElement(topsOrButtomsWomen.get(randomNumberWomen)).perform();

            if(randomNumberWomen==0){
                int randomNumberTops = RandomData.getRandomNumber(0,listTopsWomen.size());
                actions.click(listTopsWomen.get(randomNumberTops)).perform();
            }
            if(randomNumberWomen==1){
                int randomNumberBottoms = RandomData.getRandomNumber(0,listBottomsWomen.size());
                actions.click(listBottomsWomen.get(randomNumberBottoms)).perform();
            }

        }else {
            actions.moveToElement(HomePage.LINK_MEN).perform();
            topsOrButtomsMen = HomePage.LINK_MEN.findElements(By.xpath("child::ul/li/a"));
            listTopsMen = HomePage.LINK_TOPS_MEN.findElements(By.xpath("child::ul/li/a"));
            listBottomsMen = HomePage.LINK_BOTTOMS_MEN.findElements(By.xpath("child::ul/li/a"));

            int randomNumberMen = RandomData.getRandomNumber(0,topsOrButtomsMen.size());
            actions.moveToElement(topsOrButtomsMen.get(randomNumberMen)).perform();

            if(randomNumberMen==0){
                int randomNumberTops = RandomData.getRandomNumber(0,listTopsMen.size());
                actions.click(listTopsMen.get(randomNumberTops)).perform();
            }
            if(randomNumberMen==1){
                int randomNumberBottoms = RandomData.getRandomNumber(0,listBottomsMen.size());
                actions.click(listBottomsMen.get(randomNumberBottoms)).perform();
            }
        }

    }

    public void goToCart(){
        waitingTimes.waitForOneSecond();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> HomePage.LABEL_CART_ITEM_COUNT.isDisplayed());
        HomePage.LINK_CART.click();
        HomePage.BUTTON_VIEW_CART.click();
    }
}
