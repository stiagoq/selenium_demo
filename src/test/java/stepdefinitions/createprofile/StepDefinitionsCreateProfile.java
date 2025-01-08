package stepdefinitions.createprofile;

import elements.AccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import actions.AccountActions;
import actions.CreateCostumerActions;
import actions.HomePageActions;
import utils.constants.AssertsOfTestCases;
import utils.hooks.Context;
import utils.randomdata.RandomData;
import static org.testng.Assert.assertEquals;


public class StepDefinitionsCreateProfile {
    WebDriver driver;
    Context context;
    HomePageActions homePageActions;
    CreateCostumerActions createCostumerActions;
    AccountActions accountActions;
    String firstName;
    String lastName;
    String email;

    public StepDefinitionsCreateProfile(Context context){
        this.context = context;
    }
    @Before
    public void setup() {
        driver = context.getDriver();
        homePageActions = new HomePageActions(driver);
        createCostumerActions = new CreateCostumerActions(driver);
        accountActions = new AccountActions(driver);
    }

    @After
    public void tearDown() {
        context.tearDown();
    }

    @Given("User is on the main page of the site")
    public void userIsOnTheMainPageOfTheSite() {
        homePageActions.clickOnCreateAccount();
    }

    @When("enters the info in the creation profile form")
    public void entersTheInfoInTheCreationProfileForm() {
        firstName = RandomData.getRandomText("User");
        lastName = RandomData.getRandomText("User");
        email = RandomData.getRandomEmail("User");
        createCostumerActions.createCostumer(firstName, lastName, email);
    }

    @Then("it shows the user profile with your basic information")
    public void itShowsTheUserProfileWithYourBasicInformation() {
        String nameAccount = accountActions.splitContactInfo()[0];
        String emailAccount = accountActions.splitContactInfo()[1];
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        accountActions.verifyAccountCreation(firstName, email);
        assertEquals(AccountPage.LABEL_REGISTERING.getText(), AssertsOfTestCases.EXPECTED_SUCCESS_MESSAGE_REGISTER);
        if (browserName.equals("chrome")) {
            assertEquals(AccountPage.MESSAGE_SUCCESS.getCssValue("background-color"), AssertsOfTestCases.EXPECTED_RGBA_BANNER_SUCCESS_MESSAGE_REGISTER);
        }else {
            assertEquals(AccountPage.MESSAGE_SUCCESS.getCssValue("background-color"), AssertsOfTestCases.EXPECTED_RGB_BANNER_SUCCESS_MESSAGE_REGISTER);
        }
        assertEquals(nameAccount, firstName + " " + lastName);
        assertEquals(emailAccount, email);
    }
}
