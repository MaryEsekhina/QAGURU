package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${type}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("baseURL")
    String baseURL();

    @Key("remoteURL")
    String remoteURL();

}
