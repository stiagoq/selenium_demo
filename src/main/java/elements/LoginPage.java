package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@id='email']")
    public static WebElement INPUT_USERNAME;

    @FindBy(id = "pass")
    public static WebElement INPUT_PASSWORD;

    @FindBy(xpath = "//fieldset/div/div/button[contains(@class,'login')]")
    public static WebElement BUTTON_SIGN_IN;

    @FindBy(xpath = "//div[contains(@data-bind, 'foreach') and @class='messages']")
    public static WebElement LABEL_ERROR_MESSAGE;

    @FindBy(xpath = "//div[@class='control']/div[@id='email-error']")
    public static WebElement LABEL_ERROR_MESSAGE_EMAIL_FIELD;

    @FindBy(xpath = "//div[@class='control']/div[@id='pass-error']")
    public static WebElement LABEL_ERROR_MESSAGE_PASSWORD_FIELD;

}

