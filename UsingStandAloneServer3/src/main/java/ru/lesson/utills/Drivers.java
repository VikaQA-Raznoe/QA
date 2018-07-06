package ru.lesson.utills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Drivers {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            try {
                //driver = new RemoteWebDriver(new URL(urlRemoteDriver), DesiredCapabilities.chrome());
                //driver = new RemoteWebDriver(new URL("http://192.168.100.5:49144/wd/hub"), DesiredCapabilities.chrome());
                //driver = new RemoteWebDriver(new URL("127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
                driver = new RemoteWebDriver(new URL("http://192.168.100.5:49144/wd/hub"), DesiredCapabilities.chrome());
                driver.manage().window().maximize();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
