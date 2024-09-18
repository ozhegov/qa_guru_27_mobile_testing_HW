package org.wikipedia.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikiOnboardingFirstScreen {

    private final SelenideElement image = $(id("org.wikipedia.alpha:id/imageViewCentered")),
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            secondaryText = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            forwardBtn = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Проверяем, что изображение отображается на экране первой страницы")
    public WikiOnboardingFirstScreen checkFirstScreenImageIsVisible() {

        image.shouldBe(visible);

        return this;

    }

    @Step("Проверяем, что в заголовке первой страницы присутствует текст {text}")
    public WikiOnboardingFirstScreen checkFirstScreenPrimaryText(String text) {

        primaryText.shouldHave(text(text));

        return this;

    }

    @Step("Проверяем, что в описании первой страницы присутствует текст {text}")
    public WikiOnboardingFirstScreen checkFirstScreenSecondaryText(String text) {

        secondaryText.shouldHave(text(text));

        return this;

    }

    @Step("Нажимаем на кнопку 'Continue' на первой странице")
    public void clickFirstScreenForwardBtn() {

        forwardBtn.click();

    }

}
