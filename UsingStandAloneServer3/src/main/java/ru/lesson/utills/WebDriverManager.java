package ru.lesson.utills;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;
    /*public static WebDriver getDriver(){
        if (driver == null) {
            try {
                driver = new RemoteWebDriver(new URL(""), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }*/

    /*public static WebDriver getDriver(){
        //WebDriver driver = null;
        String baseUrl , nodeUrl;
        baseUrl = "https://www.facebook.com";
        //hubUrl
        nodeUrl = "http://192.168.100.5:4444/wd/hub";
        if (driver == null) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WIN8_1);

            try {
                driver = new RemoteWebDriver(new URL(nodeUrl),capability);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        }
        return driver;
    }*/

       /*public static WebDriver getDriver(){
        if (driver == null) {
            try {
                //hubUrl
                //String hubUrl = "http://192.168.100.5:13991/wd/hub";
                String hubUrl = "http://192.168.56.1:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.chrome());
                //driver = new RemoteWebDriver(new URL(hubUrl), new ChromeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }*/

    public static WebDriver getDriver(){
        String browserName = "chrome-remote";
        switch (browserName){
            case "chrome-remote":{
                try {
                    //hubUrl
                    String hubUrl = "http://192.168.100.5:13991/wd/hub";
                    //String hubUrl = "http://192.168.56.1:4444/wd/hub";
                    driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.chrome());
                    //driver = new RemoteWebDriver(new URL(hubUrl), new ChromeOptions());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return driver;
    }

}
