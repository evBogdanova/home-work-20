package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static final BrowserstackConfig browserstackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static final IosConfig iosConfig =
            ConfigFactory.create(IosConfig.class, System.getProperties());
}
