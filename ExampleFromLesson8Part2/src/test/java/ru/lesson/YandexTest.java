package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.yandex.pages.passport.PassportPage;
import ru.lesson.yandex.pages.search.YandexSearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//Тест реализован в PageObject-стиле
public class YandexTest extends BaseTest {
    @Test
    public void test(){
        //driver.get("https://yandex.ru");
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        PassportPage passportPage = yandexSearchPage.clickOnEmailBlockEmailButton();
        passportPage.inputToContentBlockLogin("red@mail.ru");
        String signNameBackgroundColor = passportPage.getSignInBacgroundColor();
        assertEquals(signNameBackgroundColor,"rgba(0,0,0,1)");
        assertTrue(passportPage.isContentBlockDisplayed());
    }
}
