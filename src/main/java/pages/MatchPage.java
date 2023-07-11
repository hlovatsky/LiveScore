package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MatchPage {

    public SelenideElement getMatchStartTime() {
        return $(byId("score-or-time"));
    }

    public SelenideElement getMatchStartDate() {
        return $(byId("SEV__status"));
    }
}
