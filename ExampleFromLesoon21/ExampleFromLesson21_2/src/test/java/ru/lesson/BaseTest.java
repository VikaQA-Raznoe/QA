package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ru.lesson.utills.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    static WebDriver driver;
    static WebDriverWait webDriverWait;
    public int timeout = 10;

    @BeforeClass
    public void tearUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        //driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT),TimeUnit.SECONDS);
        //webDriverWait = new WebDriverWait(driver,Integer.parseInt(TIMEOUT));

        driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,timeout);
        driver.get("http://ybndex.ru");
    }

/*    @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}