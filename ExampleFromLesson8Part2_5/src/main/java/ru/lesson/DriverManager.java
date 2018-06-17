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
    //private static DriverManager instance;
    //private WebDriver driver;

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static int timeout = 10;

    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    //private static final String WEB_DRIVER = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,"driver");
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");

    private DriverManager(){}

    /**
     * @return возвращает WebDriver
     */
/*    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            //VRAGA!!!
            System.setProperty("webdriver.gecko.driver", "D:\\SourceCode\\Java\\Selenium\\geckodriver.exe");
            instance.driver = new FirefoxDriver();

            instance.driver = DriverManager.getDriver();
            instance.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            instance.driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
            instance.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        }
        return instance.driver;
    }*/

    private static void createFirefoxDriver() {
        driver = new FirefoxDriver();
        //webDriverWait = new WebDriverWait(driver,timeout);
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
    }

    private static void createChromeDriver(){
        driver = new ChromeDriver();
        //webDriverWait = new WebDriverWait(driver,timeout);
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
    }

    //String value - имя браузера
    public static WebDriver getDriver() {
        if (driver == null) {
            //String value = WEB_DRIVER;
            String value = System.getProperty("browser");
            System.out.println(value);
            if (value == null) value = "firefox";
            if (value.equals("chrome")) {
                createChromeDriver();

                /*case "chrome-headless":
                    createChromeDriverHeadless();
                    break;*/
            } else if (value.equals("firefox")) {
                createFirefoxDriver();

                /*case "edge":
                    createEdgeDriver();
                    break;*/
            } else {
                createFirefoxDriver();

            }
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        return driver;
    }
}