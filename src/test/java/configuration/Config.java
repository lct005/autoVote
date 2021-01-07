package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String CONFIG_PROPERTIES = "/config.properties";
    private static final Config INSTANCE = new Config();

    private Properties properties;

    public static Config getInstance() {
        return INSTANCE;
    }

    private Config() {
        String configFile = CONFIG_PROPERTIES;
        InputStream is = this.getClass().getResourceAsStream(configFile);

        if (is != null) {
            properties = new Properties();
            try {
                properties.load(is);

                for (Object keyObj : properties.keySet()) {
                    String key = (String) keyObj;
                    if (key.startsWith("selenide.") && !System.getProperties().containsKey(key)) {
                        System.setProperty(key, properties.getProperty(key));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("Cannot read configuration file : %s", configFile), e);
            }
        } else {
            throw new RuntimeException(String.format("Cannot read configuration file : %s", configFile));
        }

//        WebDriverUtils.init(this);
    }
}
