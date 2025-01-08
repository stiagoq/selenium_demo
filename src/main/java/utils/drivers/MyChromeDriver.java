package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeDriver {
   private WebDriver chromeDriver;
    private MyChromeDriver(ChromeOptions options) {
        this.chromeDriver = new ChromeDriver(options);
    }
    public static MyChromeDriver chromeHisBrowserWeb(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--detach");
        options.addArguments("--aggressive-cache-discard");
        return new MyChromeDriver(options);
    }

    public WebDriver onTheUrl(String url) {
        chromeDriver.navigate().to(url);
        return chromeDriver;
    }
}
