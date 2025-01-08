package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    /**********************************************************************************************************************/
    /*                                              MENU                                                                  */
    /**********************************************************************************************************************/

    @FindBy(xpath = "//div[@class='panel header']/ul/li/a[contains(text(),'Create an Account')]")
    public static WebElement BUTTON_CREATE_ACCOUNT;

    @FindBy(xpath = "//div[@class='panel header']/ul/li/a[contains(text(),'Sign')]")
    public static WebElement BUTTON_SIGN_IN;

    @FindBy(xpath = "//div[@class='panel header']/ul[@class='header links']/li/span[contains(text(), 'Welcome')]")
    public static WebElement LABEL_WELCOME_MESSAGE;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'level0 nav-2')]/a[contains(@href, 'women')]/ancestor-or-self::li")
    public static WebElement LINK_WOMEN;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'nav-2')]/ul/li[contains(@class, 'nav-2-1')]")
    public static WebElement LINK_TOPS_WOMEN;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'nav-2')]/ul/li[contains(@class, 'nav-2-2')]")
    public static WebElement LINK_BOTTOMS_WOMEN;

    @FindBy (xpath = "//a[contains(@class, 'showcart')]")
    public static WebElement LINK_CART;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'level0 nav-3')]/a[contains(@href, 'men')]/ancestor-or-self::li")
    public static WebElement LINK_MEN;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'nav-3')]/ul/li[contains(@class, 'nav-3-1')]")
    public static WebElement LINK_TOPS_MEN;

    @FindBy(xpath = "//nav/ul/li[contains(@class, 'nav-3')]/ul/li[contains(@class, 'nav-3-2')]")
    public static WebElement LINK_BOTTOMS_MEN;

    @FindBy(xpath = "//a[@class='action viewcart']")
    public static WebElement BUTTON_VIEW_CART;

    @FindBy(xpath ="//span[@class='counter-number' and not(starts-with(text(),'0'))]")
    public static WebElement LABEL_CART_ITEM_COUNT;

}
