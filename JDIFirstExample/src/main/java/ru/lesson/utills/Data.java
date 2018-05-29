package ru.lesson.utills;

public class Data {

    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String FROM_PORT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "fromPort");
    private static final String TO_PORT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "toPort");


   /* public static String getPropertyFromFile(String propertyName){

    }*/
}
