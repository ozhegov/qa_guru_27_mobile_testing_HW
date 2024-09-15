package org.wikipedia.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikiOnboardingFourthScreen {

    private static final SelenideElement image = $(id("org.wikipedia.alpha:id/imageViewCentered")),
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            secondaryText = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            forwardBtn = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            doneBtn = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверяем, что изображение отображается на экране четвертой страницы")
    public WikiOnboardingFourthScreen checkFourthScreenImageIsVisible() {

        image.shouldBe(visible);

        return this;

    }

    @Step("Проверяем, что в заголовке четвертой страницы присутствует текст {text}")
    public WikiOnboardingFourthScreen checkFourthScreenPrimaryText(String text) {

        primaryText.shouldHave(text(text));

        return this;

    }

    @Step("Проверяем, что в описании четвертой страницы присутствует текст {text}")
    public WikiOnboardingFourthScreen checkFourthScreenSecondaryText(String text) {

        secondaryText.shouldHave(text(text));

        return this;

    }

    @Step("Нажимаем на кнопку 'Get Started' на четвертой странице")
    public void clickFourthScreenDoneBtn() {

        doneBtn.click();

    }

}
