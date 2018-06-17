package ru.lesson;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class YandexTest extends BaseTest {
    @Test
    public void test(){
        //Берем весь текст со страницы Yandex
        String temp = driver.findElement(By.tagName("html")).getText();
        System.out.println(temp);
        //Теперь можно проверить текст на мультиязычность,
        //перебрав каждое слово изсозданного словаря
    }
}
