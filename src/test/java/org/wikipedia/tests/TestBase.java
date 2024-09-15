package org.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.wikipedia.drivers.BrowserstackDriver;
import org.wikipedia.drivers.EmulationDriver;
import org.wikipedia.drivers.RealDeviceDriver;
import org.wikipedia.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.wikipedia.drivers.ConfigDriver.getSystemConfig;

public class TestBase {

    public static String deviceHost = getSystemConfig().getDeviceHost();

    @BeforeAll
    static void setUp() {

        switch (deviceHost) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulation" -> Configuration.browser = EmulationDriver.class.getName();
            case "real" -> Configuration.browser = RealDeviceDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {

        switch (deviceHost) {
            case "browserstack": {
                String sessionId = Selenide.sessionId().toString();
                System.out.println(sessionId);

                Attach.pageSource();
                closeWebDriver();

                Attach.addVideo(sessionId);

                break;
            }
            case "emulation", "real": {
                Attach.pageSource();
                Attach.screenshotAs("Last screenshot");

                closeWebDriver();
            }
        }
    }
}
