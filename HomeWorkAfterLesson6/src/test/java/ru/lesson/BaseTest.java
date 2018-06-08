package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.lesson.utills.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  /*  static WebDriver driver;
    static WebDriverWait webDriverWait;
    int timeout = 10;*/

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    //private static final String WEB_DRIVER = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,"webDriver");
    private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "timeout");
    @BeforeClass
    public void tearUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT),TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));
/*        driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,timeout);*/
        driver.get("http://blazedemo.com/");
    }

/*    @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}