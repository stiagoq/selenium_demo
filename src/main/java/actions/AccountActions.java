package actions;

import elements.AccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.others.CreateFiletxt;
import utils.others.WaitingTimes;


public class AccountActions {
    WebDriver driver;
    CreateFiletxt createFiletxt = new CreateFiletxt();
    WaitingTimes waitingTimes = new WaitingTimes();

    public AccountActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, AccountPage.class);
    }

    public void verifyAccountCreation(String nameUser, String emailUser){
        AccountPage.LABEL_CONTACT_INFORMATION.isDisplayed();
        AccountPage.LABEL_CONTACT_INFORMATION.getText().contains(nameUser);
        AccountPage.LABEL_CONTACT_INFORMATION.getText().contains(emailUser);
        waitingTimes.waitForThreeSecond();
    }

    public  String [] splitContactInfo (){
        String contactInfo = AccountPage.LABEL_CONTACT_INFORMATION.getText();
        createFiletxt.createFile("src/main/java/utils/dataoftest/userinfo.txt", contactInfo);
        return contactInfo.split("\\R");
    }

}
