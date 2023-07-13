package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@UtilityClass
public class DriverConfigurator {
    public WebDriver driver = null;
    public final ConfigsReader configsReader = ConfigFactory.create(ConfigsReader.class);

    private String getBrowserName() {
        String mavenBrowser = System.getProperty("browser");
        String propBrowser = configsReader.defaultBrowser();
        return mavenBrowser != null ? mavenBrowser : propBrowser;
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }

    private WebDriver createDriver(String browserName){
        switch (browserName){
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Browser Name was not recognized!");
        }
    }

    public void setBaseConfigs(){
        Configuration.baseUrl = configsReader.baseUrl();
        Configuration.reportsFolder = "target/selenideRep/";
    }

    public WebDriver getDriver(){
        if (driver == null){
            return createDriver(getBrowserName());
        }
        return driver;
    }
}
