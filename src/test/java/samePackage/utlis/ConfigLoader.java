package samePackage.utlis;

import samePackage.constants.EnvType;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {

        String env = System.getProperty("env");

        if (env == null) {
            env = EnvType.STAGE.name(); // default
        }

        EnvType envType;
        try {
            envType = EnvType.valueOf(env.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid env value: " + env +
                    ". Use -Denv=DEV|QA|STAGE|PROD");
        }

        if (envType == EnvType.STAGE) {
            properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
        } else {
            throw new RuntimeException("Environment not supported yet: " + envType);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("Property 'baseUrl' is missing in config.properties");
    }
}
