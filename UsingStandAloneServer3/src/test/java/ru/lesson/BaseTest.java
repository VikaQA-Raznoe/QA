package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import ru.lesson.utills.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void tearUp(){
        driver = WebDriverManager.getDriver();
        driver.get("https://yandex.ru");
    }
}
