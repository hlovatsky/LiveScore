package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.StartPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class StartPageSteps {

    private static final Logger LOG = LogManager.getLogger(StartPageSteps.class);

    StartPage startPage = page(StartPage.class);

    @Given("user is on start page")
    public void userIsOnStartPage() {
        open("https://www.livescore.com/en/");
        startPage.closeCookieBar();
        LOG.info("user is on start page");
    }

    @When("user clicks on any not started event")
    public void userClicksOnAnyNotStartedEvent() {
        startPage.clickOnAnyNotStartedEvent();
    }

    @When("user opens site menu")
    public void userOpensSiteMenu() {
        startPage.getSiteMenu().shouldBe(visible).click();
    }

    @And("user click the {string} button")
    public void userClickTheButton(final String buttonName) {
        startPage.getSomeElementByText(buttonName).shouldBe(visible).click();
        LOG.info("user click the {} button", buttonName);
    }
}
