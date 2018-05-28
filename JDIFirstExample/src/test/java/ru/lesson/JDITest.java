package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import ru.lesson.pages.WelcomePage;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.open;

public class JDITest extends  BaseTest{

    @Test
    public void welcomePageTest(){
        //WebDriverManager.firefoxdriver().setup();
        //Открытие страницы сайта
        open();
        //chooseItemClickButton();
        //clickButtonChooseThisFlightButton();
    }
}
