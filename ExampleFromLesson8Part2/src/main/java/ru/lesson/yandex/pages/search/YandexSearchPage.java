package ru.lesson.yandex.pages.search;

import ru.lesson.BasePage;
import ru.lesson.yandex.pages.passport.PassportPage;
import ru.lesson.yandex.pages.search.components.EmailBlock;

import static ru.lesson.utills.WebDriverManager.driver;

public class YandexSearchPage extends BasePage {

/*    public YandexSearchPage() {
        driver.get("https://yandex.ru");
    }*/

    //Инициализация элементов страницы(блока входа в почту)
    EmailBlock emailBlock;

    public PassportPage clickOnEmailBlockEmailButton(){
        emailBlock = new EmailBlock();
        emailBlock.clickOnEnterToEmailButton();
        return new PassportPage();
    }
}
