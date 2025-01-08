package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class MyFirefoxDriver {
    WebDriver firefoxDriver;

    public MyFirefoxDriver(FirefoxOptions options) {
        this.firefoxDriver = new FirefoxDriver(options);
    }

    public static MyFirefoxDriver firefoxHisBrowserWeb(){
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("-private-window");
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        options.addArguments("-headless");
        return new MyFirefoxDriver(options);
    }

    public WebDriver onTheUrl(String url) {
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firefoxDriver.navigate().to(url);
        return firefoxDriver;
    }


}
