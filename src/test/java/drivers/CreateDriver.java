package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {

    public static WebDriver driver;

    public static WebDriver createDriver(){
        System.setProperty("webdriver.gecko.driver", "/home/rafael/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://seubarriga.wcaquino.me/login");
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
