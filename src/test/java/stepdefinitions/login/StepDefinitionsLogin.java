package stepdefinitions.login;

import elements.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import actions.HomePageActions;
import actions.LoginActions;
import utils.constants.Constants;
import utils.hooks.Context;
import utils.others.ReadFile;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StepDefinitionsLogin {
    WebDriver driver;
    HomePageActions homePageActions;
    LoginActions loginActions;
    ReadFile readFile;
    List<String> infoUser = new ArrayList<>();
    Context context;

    public StepDefinitionsLogin(Context context) {
        this.context = context;
        driver = context.getDriver();
        homePageActions = new HomePageActions(driver);
        loginActions = new LoginActions(driver);
    }

    @After
    public void tearDown() {
        context.tearDown();
    }

    @Given("user is on the login page of the site")
    public void userIsOnTheLoginPageOfTheSite() {
        context.setup();
        homePageActions.openLoginPage();
    }

    @When("enters the credentials")
    public void entersTheCredentials() {
        readFile = new ReadFile();
        readFile.readFile("src/main/java/utils/dataoftest/userinfo.txt", infoUser);
        loginActions.login(infoUser.get(1), Constants.PASSWORD);
    }

    @Then("it shows the user profile and your home page")
    public void itShowsTheUserProfileAndYourHomePage() {
        homePageActions.waitElementVisible(HomePage.LABEL_WELCOME_MESSAGE);
       String userFirstName = homePageActions.splitWelcomeMessage()[1];
       String userLastName = homePageActions.splitWelcomeMessage()[2];
       assertEquals(userFirstName + " " + userLastName , infoUser.get(0));
    }
}
