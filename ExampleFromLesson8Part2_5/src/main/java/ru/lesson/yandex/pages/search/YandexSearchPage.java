package ru.lesson.yandex.pages.search;


import ru.lesson.AbstractPage;
import ru.lesson.yandex.pages.passport.PassportPage;
import ru.lesson.yandex.pages.search.components.EmailBlock;



public class YandexSearchPage extends AbstractPage {

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

    /*public void loadUrl(String address) {

    }*/

    public void load(){
        driver.get("https://yandex.ru");
    }
}
