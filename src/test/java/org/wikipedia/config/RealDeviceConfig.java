package org.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:realdevice.properties"
})
public interface RealDeviceConfig extends Config {

    @Key("automationName")
    String getAutomationName();

    @Key("platformName")
    String getPlatformName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("url")
    String getUrl();

    @Key("appVersion")
    String getAppVersion();

    @Key("appUrl")
    String getAppUrl();

    @Key("appPath")
    String getAppPath();

}
