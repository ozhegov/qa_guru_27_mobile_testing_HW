package org.wikipedia.drivers;

import org.aeonbits.owner.ConfigFactory;
import org.wikipedia.config.*;


public class ConfigDriver {

    private static final AuthConfig authConfig =
            ConfigFactory.create(
                    AuthConfig.class,
                    System.getProperties()
            );
    private static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(
                    BrowserstackConfig.class,
                    System.getProperties()
            );

    private static EmulationConfig emulationConfig =
            ConfigFactory.create(
                    EmulationConfig.class,
                    System.getProperties()
            );

    private static RealDeviceConfig realDeviceConfig =
            ConfigFactory.create(
                    RealDeviceConfig.class,
                    System.getProperties()
            );

    private static SystemConfig systemConfig =
            ConfigFactory.create(
                    SystemConfig.class,
                    System.getProperties()
            );

    public static AuthConfig getAuthConfig() {
        return authConfig;
    }

    public static BrowserstackConfig getBrowserstackConfig() {
        return browserstackConfig;
    }

    public static EmulationConfig getEmulationConfig() {
        return emulationConfig;
    }

    public static RealDeviceConfig getRealDeviceConfig() {
        return realDeviceConfig;
    }

    public static SystemConfig getSystemConfig() {
        return systemConfig;
    }

}
