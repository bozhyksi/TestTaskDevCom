package stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverConfigurator;

public class Hooks {

    @Before
    public void setUp() {
        DriverConfigurator.setBaseConfigs();
        WebDriverRunner.setWebDriver(DriverConfigurator.getDriver());
    }

    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        DriverConfigurator.driver = null;
    }
}
