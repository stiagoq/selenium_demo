package actions;

import elements.CreateCostumerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.constants.Constants;


public class CreateCostumerActions {
    WebDriver driver;

    public CreateCostumerActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateCostumerPage.class);
    }

    public void createCostumer(String firstname, String lastname, String email) {
        CreateCostumerPage.INPUT_FIRST_NAME.sendKeys(firstname);
        CreateCostumerPage.INPUT_LAST_NAME.sendKeys(lastname);
        CreateCostumerPage.INPUT_EMAIL_ADDRESS.sendKeys(email);
        CreateCostumerPage.INPUT_PASSWORD.sendKeys(Constants.PASSWORD);
        CreateCostumerPage.INPUT_CONFIMATION_PASSWORD.sendKeys(Constants.PASSWORD);
        CreateCostumerPage.BUTTON_SUBMIT.click();
    }
}
