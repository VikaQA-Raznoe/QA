package ru.lesson6_8.utils;

import com.thoughtworks.gauge.Step;


public class AppLauncher {

    public static String WEBSITE_URL = System.getenv("url");

    @Step("Go to the website")
    public void launchTheApplication() {
        Driver.webDriver.get(WEBSITE_URL);
    }
}