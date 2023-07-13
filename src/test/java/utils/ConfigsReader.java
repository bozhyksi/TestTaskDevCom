package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ConfigsReader extends Config {

    String defaultBrowser();
    String baseUrl();
}
