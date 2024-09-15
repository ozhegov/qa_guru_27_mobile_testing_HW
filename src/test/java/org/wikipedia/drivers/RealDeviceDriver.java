package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.wikipedia.drivers.ConfigDriver.getRealDeviceConfig;

public class RealDeviceDriver implements WebDriverProvider  {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(getRealDeviceConfig().getAutomationName())
                .setPlatformName(getRealDeviceConfig().getPlatformName())
                .setPlatformVersion(getRealDeviceConfig().getPlatformVersion())
                .setDeviceName(getRealDeviceConfig().getDeviceName())
                .setApp(getAppPath())
                .setAppPackage(getRealDeviceConfig().getAppPackage())
                .setAppActivity(getRealDeviceConfig().getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(getRealDeviceConfig().getUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {

        String appVersion = getRealDeviceConfig().getAppVersion();
        String appUrl = getRealDeviceConfig().getAppUrl() + appVersion;
        String appPath = getRealDeviceConfig().getAppPath() + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application");
            }
        }

        return app.getAbsolutePath();

    }

}
