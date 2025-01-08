package utils.others;

import org.openqa.selenium.WebDriver;
import utils.constants.Constants;
import utils.drivers.MyChromeDriver;
import utils.drivers.MyFirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
    MyChromeDriver myChromeDriver;
    public WebDriver driver;
    Properties properties;
    String environment;


    public BaseClass(){
        properties = new Properties();
        environment = System.getProperty("environment", "qa");
        try {
            FileInputStream file = new FileInputStream(new File("config.properties"));
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(environment + "." + key);
    }

    public void setup()
    {
        if(driver==null)
        {
            String baseUrl = getProperty("baseUrl");
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = MyChromeDriver.chromeHisBrowserWeb().onTheUrl(baseUrl);
                    break;
                case "firefox":
                    driver = MyFirefoxDriver.firefoxHisBrowserWeb().onTheUrl(baseUrl);
                    break;
                default:
                    throw new IllegalArgumentException("Navegador no soportado: " + browser);
            }
        }
    }

    public void openBaseURL()
    {
        driver = myChromeDriver.onTheUrl(Constants.BASE_URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown()
    {
        driver.quit();
    }
}
