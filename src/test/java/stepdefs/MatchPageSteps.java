package stepdefs;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.MatchPage;

import java.time.LocalTime;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.MatchDateType.MATCH_START_DATE;
import static enums.TimeZone.TIME_ZONE;
import static org.testng.Assert.assertEquals;
import static utils.BufferContext.getContext;
import static utils.BufferContext.setContext;
import static utils.DateUtils.*;

public class MatchPageSteps {
    private static final Logger LOG = LogManager.getLogger(MatchPageSteps.class);

    MatchPage matchPage = page(MatchPage.class);

    @Then("match start day and time are visible")
    public void isVisible() {
        matchPage.getMatchStartTime().shouldBe(visible);
        matchPage.getMatchStartDate().shouldBe(visible);
        setContext(MATCH_START_DATE, matchPage.getMatchStartDate().getText());
        LOG.info("match start day and time are visible");
    }

    @Then("the start date and time of the event changed accordingly")
    public void theStartDateAndTimeOfTheEventChangedAccordingly() {
        String displayedTime = matchPage.getMatchStartTime().shouldBe(visible).getText();
        LocalTime actualTime = parseStringToLocalTime(displayedTime);
        LocalTime expectedTime = convertMatchStartTimeToUtc(getContext(TIME_ZONE), actualTime.getHour(), actualTime.getMinute());
        LocalTime adjustedExpectedTime = expectedTime.plusHours(adjustingExpectedTime(getContext(TIME_ZONE)).toHours());
        assertEquals(actualTime, adjustedExpectedTime, "Time was not changed correctly.");
    }
}
