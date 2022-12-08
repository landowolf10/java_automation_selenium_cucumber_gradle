package framework.config;

import framework.utils.ConstantData;

import java.util.HashMap;

public class RunSettings {
    public static HashMap<String, String> loadConfig() {
        HashMap<String, String> settings = new HashMap<>();

        settings.put("chromeDriver", ConstantData.chromeDriver);
        settings.put("driverPath", ConstantData.driverPath);
        settings.put("URL", ConstantData.URL);

        return settings;
    }
}
