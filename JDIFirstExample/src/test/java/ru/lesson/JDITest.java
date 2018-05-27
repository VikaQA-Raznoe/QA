package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static ru.lesson.JDIExampleSite.clickButton;


public class JDITest extends  BaseTest{
    @Test
    public void welcomePageTest(){
        WebDriverManager.firefoxdriver().setup();
        clickButton();
    }
}
