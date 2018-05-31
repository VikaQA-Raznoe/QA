package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.open;
import static ru.lesson.EpamJDISite.welcomePage;


public class FirstTest extends WebDriverManager {

    @Test
    public void test1(){
        open();
        welcomePage.selectCitiesAndSubmitForm();
    }
}