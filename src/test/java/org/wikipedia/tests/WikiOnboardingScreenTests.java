package org.wikipedia.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wikipedia.screens.*;

import static org.wikipedia.utils.TestData.*;

@Feature("Онбординг в приложении Wikipedia")
@Story("Прохождение пользователем онбординга")
public class WikiOnboardingScreenTests extends TestBase {

    WikiOnboardingFirstScreen firstOnboardingScreen = new WikiOnboardingFirstScreen();
    WikiOnboardingSecondScreen secondOnboardingScreen = new WikiOnboardingSecondScreen();
    WikiOnboardingThirdScreen thirdOnboardingScreen = new WikiOnboardingThirdScreen();
    WikiOnboardingFourthScreen fourthOnboardingScreen = new WikiOnboardingFourthScreen();
    WikiMainScreen mainScreen = new WikiMainScreen();

    @Test
    @DisplayName("После прохождения онбординга отображается главный экран приложения")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Maksim Ozhegov")
    public void mainWikiScreenShouldBeVisibleAfterOnboarding() {

        firstOnboardingScreen
                .checkFirstScreenImageIsVisible()
                .checkFirstScreenPrimaryText(FIRST_SCREEN_PRIMARY_TEXT)
                .checkFirstScreenSecondaryText(FIRST_SCREEN_SECONDARY_TEXT)
                .clickFirstScreenForwardBtn();

        secondOnboardingScreen
                .checkSecondScreenImageIsVisible()
                .checkSecondScreenPrimaryText(SECOND_SCREEN_PRIMARY_TEXT)
                .checkSecondScreenSecondaryText(SECOND_SCREEN_SECONDARY_TEXT)
                .clickSecondScreenForwardBtn();

        thirdOnboardingScreen
                .checkThirdScreenImageIsVisible()
                .checkThirdScreenPrimaryText(THIRD_SCREEN_PRIMARY_TEXT)
                .checkThirdScreenSecondaryText(THIRD_SCREEN_SECONDARY_TEXT)
                .clickThirdScreenForwardBtn();

        fourthOnboardingScreen
                .checkFourthScreenImageIsVisible()
                .checkFourthScreenPrimaryText(FOURTH_SCREEN_PRIMARY_TEXT)
                .checkFourthScreenSecondaryText(FOURTH_SCREEN_SECONDARY_TEXT)
                .clickFourthScreenDoneBtn();

        mainScreen
                .checkWikiLogoIsVisibleOnMainScreen()
                .checkSearchInputIsVisibleOnMainScreen();

    }

}
