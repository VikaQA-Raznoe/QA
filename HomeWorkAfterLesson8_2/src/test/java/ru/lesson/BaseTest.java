package ru.lesson;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeClass
    public void tearUp(){
        DriverManager.getDriver().get("http://blazedemo.com/login");
    }

    @AfterClass
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}