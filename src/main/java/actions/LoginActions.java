package actions;

import elements.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.constants.AssertsOfTestCases;
import java.time.Duration;

public class LoginActions {
    Wait<WebDriver> wait;
    WebDriver driver;

    public LoginActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, LoginPage.class);
    }

    public void login(String username, String password){
        LoginPage.INPUT_USERNAME.sendKeys(username);
        LoginPage.INPUT_PASSWORD.sendKeys(password);
        LoginPage.BUTTON_SIGN_IN.click();
    }

    public void waitElementVisible(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed());
    }

    public void validateErrorMessage() {
        LoginPage.LABEL_ERROR_MESSAGE.isDisplayed();
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String stringBackgroundColor = LoginPage.LABEL_ERROR_MESSAGE.findElement(By.xpath("child::div[contains(@class, 'message')]"))
                .getCssValue("background-color");
        String stringErrorMessage = LoginPage.LABEL_ERROR_MESSAGE.findElement(By.xpath("child::div[contains(@class, 'message')]/div"))
                .getText();
        if (browserName.equals("chrome")) {
            if (!stringBackgroundColor.equals(AssertsOfTestCases.EXPECTED_RGBA_BANNER_ERROR_MESSAGE_LOGIN)) {
                throw new AssertionError("The background " + stringBackgroundColor + " color of error message is not as expected: " + AssertsOfTestCases.EXPECTED_RGBA_BANNER_ERROR_MESSAGE_LOGIN);
            }
            if (!stringErrorMessage.equals(AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_LOGIN)) {
                throw new AssertionError("The error message is not as expected");
            }
        } else {
            if (!stringBackgroundColor.equals(AssertsOfTestCases.EXPECTED_RGB_BANNER_ERROR_MESSAGE_LOGIN)) {
                throw new AssertionError("The background " + stringBackgroundColor + " color of error message is not as expected: " + AssertsOfTestCases.EXPECTED_RGBA_BANNER_ERROR_MESSAGE_LOGIN);
            }
            if (!stringErrorMessage.equals(AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_LOGIN)) {
                throw new AssertionError("The error message is not as expected");
            }
        }
    }
}
