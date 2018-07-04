package ru.lesson.utills;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {

    private static WebDriver driver;

    public static void getDriver() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox" );
        //capability.setPlatform(Platform.LINUX);
        capability.setPlatform(Platform.WIN8);
        //capability.setVersion("3.6");
        capability.setVersion("latest");
        URL hostURL = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(hostURL, capability);
        driver.get("https://yandex.ru");
    }
}
