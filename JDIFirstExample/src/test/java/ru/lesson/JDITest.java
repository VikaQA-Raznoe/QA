package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import ru.lesson.pages.WelcomePage;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.open;
import static ru.lesson.EpamJDISite.welcomePage;

public class JDITest extends  BaseTest{

    @Test
    public void welcomePageTest(){
        //---РАБОТАЕТ--- var1 ---bonigarcia
        //WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        open();
        welcomePage.selectCitiesAndSubmitForm();
        //---РАБОТАЕТ---
    }
}
