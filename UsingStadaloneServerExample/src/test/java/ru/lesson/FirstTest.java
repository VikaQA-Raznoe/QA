package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.lesson.utills.WebDriverManager;

import java.net.MalformedURLException;

public class FirstTest {

    @Test
    public void test1() throws MalformedURLException {
        WebDriverManager.getDriver();
    }
}
