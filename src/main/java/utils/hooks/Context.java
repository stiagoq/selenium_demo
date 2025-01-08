package utils.hooks;

import actions.HomePageActions;
import actions.LoginActions;
import utils.constants.Constants;
import utils.others.BaseClass;


public class Context extends BaseClass {
    private HomePageActions homePageActions;
    private LoginActions loginActions;

    public Context() {
        setup();
    }

    public void  getLoginAndLogin()
    {
            loginActions = new LoginActions(driver);
            homePageActions = new HomePageActions(driver);
            homePageActions.openLoginPage();
            loginActions.login(Constants.USERNAME, Constants.PASSWORD);
    }
}
