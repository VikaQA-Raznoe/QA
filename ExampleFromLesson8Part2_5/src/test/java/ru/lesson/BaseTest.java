package ru.lesson;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeClass
    public void tearUp(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //webDriverWait = new WebDriverWait(driver,10);
        //driver.get("https://yandex.ru");
        DriverManager.getDriver().get("https://yandex.ru");
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
        DriverManager.getDriver().quit();
    }
}
