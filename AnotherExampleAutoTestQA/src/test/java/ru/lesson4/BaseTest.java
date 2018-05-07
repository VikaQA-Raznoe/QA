package ru.lesson4;

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
    static WebDriverWait webDriverWait;
    int timeout = 10;

    @BeforeClass
    public void tearUp(){
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,timeout);
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
    }

    /*@AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
