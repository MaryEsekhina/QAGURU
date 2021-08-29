package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file: /Users/1/api.properties",
        "system:properties"
})
public interface ApiConfig extends Config {

    @Key("baseURL")
    String baseURL();

    @Key("token")
    String token();
}
