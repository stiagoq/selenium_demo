package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(xpath = "//div[contains(@data-bind, 'html') and contains(text(),'registering')]")
    public static WebElement LABEL_REGISTERING;

    @FindBy(xpath = "//div[@class='box box-information']/div/p")
    public static WebElement LABEL_CONTACT_INFORMATION;

    @FindBy(xpath = "//div[contains(@class, 'message-success')]")
    public static WebElement MESSAGE_SUCCESS;
}
