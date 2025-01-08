package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCostumerPage {
    @FindBy(name = "firstname")
    public static WebElement INPUT_FIRST_NAME;

    @FindBy(name = "lastname")
    public static WebElement INPUT_LAST_NAME;

    @FindBy(id = "email_address")
    public static WebElement INPUT_EMAIL_ADDRESS;

    @FindBy(id = "password")
    public static WebElement INPUT_PASSWORD;

    @FindBy(id = "password-confirmation")
    public static WebElement INPUT_CONFIMATION_PASSWORD;

    @FindBy(xpath = "//button[contains(@class, 'submit primary')]")
    public static WebElement BUTTON_SUBMIT;
}
