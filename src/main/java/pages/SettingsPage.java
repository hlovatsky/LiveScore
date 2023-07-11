package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class SettingsPage {

    public SelenideElement getTimeZoneField() {
        return $(byId("TZ_SELECT-label"));
    }

    public String getHourOfTimeZoneValue() {
        return $x("//label[@id='TZ_SELECT-label']").shouldBe(visible).getText().split("[ :]")[1];
    }

    public void chooseTimeZone() {
        $$x("//div[contains(@class,'Ui selectItem')]")
                .asFixedIterable()
                .stream()
                .filter(element -> !element.getText().contains("Automatic"))
                .findAny()
                .ifPresent(SelenideElement::click);
    }
}
