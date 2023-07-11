package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void beforeSteps() {
        setupConfigurations();
    }

    public void setupConfigurations() {
        Configuration.browserSize = "1500x800";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        Configuration.savePageSource = false;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
