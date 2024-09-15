package org.wikipedia.config;

import org.aeonbits.owner.Config;

public interface SystemConfig extends Config {

    @Key("deviceHost")
    @DefaultValue("browserstack")
    String getDeviceHost();

}
