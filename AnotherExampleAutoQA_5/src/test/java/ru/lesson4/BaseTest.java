package ru.lesson4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class BaseTest {
    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static int timeout = 10;

    /*@org.testng.annotations.BeforeClass
    public void beforeClass(){
        webDriver = new ChromeDriver();
        //Ждем загрузки страницы 10 секунд
        webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver,timeout);
        webDriver.get("http://book.theautomatedtester.co.uk/chapter1");
    }*/


    private static void createFirefoxDriver() {
        webDriver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(webDriver,timeout);
    }

    private static void createChromeDriver(){
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver,timeout);
    }

    //String value - имя браузера
    public static WebDriver getDriver() {
        if (webDriver == null) {
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
            webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        return webDriver;
    }

    @BeforeClass
    public void beforeAllTests() {
        webDriver = getDriver();
    }

    @AfterClass
    public void afterAllTests() {
        webDriver.quit();
    }
}