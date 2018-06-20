package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lesson.utills.PropertyReader;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;


/**
 * LoggerManager для получения WebDriver.
 * Используется при создании страниц. Вызов getDriver() происходит в AbstractPage.
 */
public class DriverManager {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static int timeout = 10;

    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");

    private DriverManager(){}

    private static void createFirefoxDriver() {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
    }

    private static void createChromeDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
    }

    //String value - имя браузера
    public static WebDriver getDriver() {
        if (driver == null) {
            String value = System.getProperty("browser");
            System.out.println(value);
            if (value == null) value = "firefox";
            if (value.equals("chrome")) {
                createChromeDriver();
            } else if (value.equals("firefox")) {
                createFirefoxDriver();
            } else {
                createFirefoxDriver();

            }
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        }
        return driver;
    }
}