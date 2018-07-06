package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import ru.lesson.utills.Drivers;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void tearUp(){
        driver = Drivers.getDriver();
        driver.get("https://yandex.ru");
    }
}
