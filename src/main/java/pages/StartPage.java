package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    public SelenideElement getSiteMenu() {
        return $(byId("burger-menu-open"));
    }

    public SelenideElement getNextDay() {
        return $x("//a[contains(@data-testid,'match-calendar-link-active')]/following-sibling::a[1]");
    }

    public ElementsCollection getEvents() {
        return $$x("//div[contains(@class,'yo Co') and contains(@id,'match-row')]");
    }

    public void clickOnAnyNotStartedEvent() {
        if ($x("//div[contains(@class,'yo Co') and contains(@id,'match-row')]").shouldHave(innerText("")).is(disappear)) {
            getNextDay().click();
        }
        getEvents()
                .filterBy(innerText("")).first().click();
    }

    public void closeCookieBar() {
        $(byId("simpleCookieBarCloseButton")).click();
    }

    public SelenideElement getSomeElementByText(final String text) {
        return $(byText(text));
    }
}
