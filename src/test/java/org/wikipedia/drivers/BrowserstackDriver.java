package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static org.wikipedia.drivers.ConfigDriver.getAuthConfig;
import static org.wikipedia.drivers.ConfigDriver.getBrowserstackConfig;


public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", getAuthConfig().getLogin());
        caps.setCapability("browserstack.key", getAuthConfig().getPassword());

        caps.setCapability("app", getBrowserstackConfig().getApp());
        caps.setCapability("device", getBrowserstackConfig().getDevice());
        caps.setCapability("os_version", getBrowserstackConfig().getVersion());

        caps.setCapability("project", getBrowserstackConfig().getProject());
        caps.setCapability("build", getBrowserstackConfig().getBuild());
        caps.setCapability("name", getBrowserstackConfig().getName());

        try {
            return new RemoteWebDriver(
                    new URL(getBrowserstackConfig().getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
