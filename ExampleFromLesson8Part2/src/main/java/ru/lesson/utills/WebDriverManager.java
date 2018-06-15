package ru.lesson.utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            String browserName = System.getProperty("browser");
            if (browserName == null || (browserName.equals("")))
            {
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
