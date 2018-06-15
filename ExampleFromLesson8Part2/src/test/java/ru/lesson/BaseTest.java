package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    int timeout = 10;
    /*    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
        private static final String TIMEOUT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
                "timeout");*/
    @BeforeClass
    public void tearUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,10);
        driver.get("https://yandex.ru");
    }

/*    @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}