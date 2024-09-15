package org.wikipedia.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikiMainScreen {

    private static final SelenideElement wikiLogo = $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")),
            searchInput = $(accessibilityId("Search Wikipedia"));


    @Step("Проверяем, что логотип Wikipedia отображается на экране главной страницы")
    public WikiMainScreen checkWikiLogoIsVisibleOnMainScreen() {

        wikiLogo.shouldBe(visible);

        return this;

    }

    @Step("Проверяем, что поле поиска отображается на экране главной страницы")
    public void checkSearchInputIsVisibleOnMainScreen() {

        searchInput.shouldBe(visible);

    }

}
