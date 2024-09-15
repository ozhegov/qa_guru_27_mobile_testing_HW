package org.wikipedia.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "classpath:device_properties/${deviceName}.properties",
        "classpath:device_properties/samsung.properties",
        "classpath:device_properties/pixel.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("version")
    String getVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();

}
