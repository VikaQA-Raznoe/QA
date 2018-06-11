package ru.lesson;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lesson.pages.EmailMainPage;
import ru.lesson.pages.MainPage;
import ru.lesson.pages.MainPage2;

/**
 * Показана реализация PageObject в Selenide
 * На основе советов Солнцева: https://gitter.im/codeborne/selenide-ru/archives/2018/03/26
 */
public class MailRuPageObjectTest {

    @BeforeTest
    public void beforeTest(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test(){
        MainPage2 mainPage2 = new MainPage2();
        mainPage2.enterToMainPage();
        mainPage2.inputToLogin("neo-737@bk.ru");
        mainPage2.inputToPassword("qw99op");
        EmailMainPage emailMainPage = mainPage2.clickOnButtonLogin();
        emailMainPage.checkVisible();
    }
}
