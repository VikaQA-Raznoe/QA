package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.yandex.pages.passport.PassportPage;
import ru.lesson.yandex.pages.search.YandexSearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class YandexTest extends BaseTest{
    @Test
    public void test(){
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        //yandexSearchPage.load();
        PassportPage passportPage = yandexSearchPage.clickOnEmailBlockEmailButton();
        passportPage.inputToContentBlockLogin("red@mail.ru");
        String signNameBackgroundColor = passportPage.getSignInBacgroundColor();
        System.out.println(signNameBackgroundColor);
        //assertEquals(signNameBackgroundColor,"rgba(0, 0, 0, 1)");
        assertEquals(signNameBackgroundColor,"rgba(0, 0, 0, 0)");
        assertTrue(passportPage.isContentBlockDisplayed());

    }
}