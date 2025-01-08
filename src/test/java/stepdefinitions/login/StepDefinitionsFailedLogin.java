package stepdefinitions.login;

import elements.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import actions.HomePageActions;
import actions.LoginActions;
import utils.constants.AssertsOfTestCases;
import utils.hooks.Context;
import utils.others.ReadFile;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;

public final class StepDefinitionsFailedLogin {
    WebDriver driver;
    Context context;
    HomePageActions homePageActions;
    LoginActions loginActions;
    ReadFile readFile;
    List<String> infoUser = new ArrayList<>();
    String dataInputPass;
    String dataInputEmail;

    public StepDefinitionsFailedLogin(Context context) {
        this.context = context;
        driver = context.getDriver();
        homePageActions = new HomePageActions(driver);
        loginActions = new LoginActions(driver);
    }

    @When("enters invalid {string} and {string} credentials")
    public void entersInvalidAndCredentials(String emailUser, String password) {
        if (emailUser.contains(".txt")){
            readFile = new ReadFile();
            readFile.readFile("src/main/java/utils/dataoftest/" + emailUser, infoUser);
            loginActions.login(infoUser.get(1), password);
        }else{
            loginActions.login(emailUser, password);
        }
        dataInputEmail = emailUser;
        dataInputPass = password;
    }

    @Then("it shows an error message")
    public void itShowsAnErrorMessage() {
        if(dataInputPass!="" && dataInputEmail!=""){
            loginActions.waitElementVisible(LoginPage.LABEL_ERROR_MESSAGE);
            loginActions.validateErrorMessage();
        } else if (dataInputPass!="" && dataInputEmail=="") {
            assertEquals(LoginPage.LABEL_ERROR_MESSAGE_EMAIL_FIELD.getText(), AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_FIELD);
        } else if (dataInputPass=="" && dataInputEmail!="") {
            assertEquals(LoginPage.LABEL_ERROR_MESSAGE_PASSWORD_FIELD.getText(), AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_FIELD);
        }else {
            assertEquals(LoginPage.LABEL_ERROR_MESSAGE_EMAIL_FIELD.getText(), AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_FIELD);
            assertEquals(LoginPage.LABEL_ERROR_MESSAGE_PASSWORD_FIELD.getText(), AssertsOfTestCases.EXPECTED_ERROR_MESSAGE_FIELD);
        }
    }

}
