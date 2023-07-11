package stepdefs;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.SettingsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.TimeZone.TIME_ZONE;
import static utils.BufferContext.setContext;

public class SettingsPageSteps {
    private static final Logger LOG = LogManager.getLogger(SettingsPageSteps.class);

    SettingsPage settingsPage = page(SettingsPage.class);

    @And("user chooses new time zone")
    public void userChoosesNewTimeZone() {
        settingsPage.getTimeZoneField().shouldBe(visible).click();
        settingsPage.chooseTimeZone();
        setContext(TIME_ZONE, settingsPage.getHourOfTimeZoneValue());
        LOG.info("user chooses new time zone");
    }
}
