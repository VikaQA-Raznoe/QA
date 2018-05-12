package ru.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.lesson4.utills.PropertyReader;

import java.util.concurrent.TimeUnit;
import static java.lang.Integer.parseInt;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    //private static final String WEB_DRIVER = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,"webDriver");
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");

    private static void createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver,parseInt(TIMEOUT));
    }

    private static void createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver,parseInt(TIMEOUT));
    }

    //String value - имя браузера
    public static WebDriver getDriver() {
        if (driver == null) {
            //String value = WEB_DRIVER;
            String value = System.getProperty("browser");
            System.out.println(value);
            if (value == null) value = "firefox";
            switch (value) {
                case "chrome":
                    createChromeDriver();
                    break;
                /*case "chrome-headless":
                    createChromeDriverHeadless();
                    break;*/
                case "firefox":
                    createFirefoxDriver();
                    break;
                /*case "edge":
                    createEdgeDriver();
                    break;*/
                default:
                    createFirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(parseInt(TIMEOUT), TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        return driver;
    }

    @BeforeClass
    public void beforeAllTests() {
        driver = getDriver();
    }

    @AfterClass
    public void afterAllTests() {
        driver.quit();
    }
}