package ru.lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Тест-кейс:
 * 1. Открыть страницу https://www.google.com/
 * 2. Выполнить поиск "Любой запрос"
 * 3. Проверить, что результаты поиска отобразились
 * 4. Проверить, что резульатов на странице 10
 * 5. Проверить, что текст с вашим запросом находится в первом результате
 */

public class GoogleTest {
    @Test
    public void mainGooglePagetTest(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        open("https://www.google.com/");
        //Ввести в строку поиска слово "Mersedes"
        //$("#lst-ib").setValue("Mersedec");
        //Ввести в строку поиска слово "Mersedes" и нажать на кнопку "Enter"
        $("#lst-ib").setValue("Mercedes").pressEnter();

        //fixme:Кол-во элементов на странице не совпадает с нужнгым. Как быть??
        //Проверить, что результатов на странице 10
        //Для этого нужно найти элемент, в который входят все найденные элменты(сайты)
        $$("#ires .g").shouldHave(size(10));

        //Получить значение первой ссылки
        //String t = $(".ads-ad cite").getText();
        //System.out.println(t);

        //fixme:Откуда появился такой селектор??
        //Клиикнуть на третью ссылку
        //$x("//*[@id='search']/descendant::cite[3]").click();

        //находит элемент по тексту целиком.shouldBe(visible);
        //$(byText("«Мерседес-Бенц» GLS | в «Олимп Нева» | mercedes-olimp-neva.ru")).shouldBe(visible);
        //String foo = $(By.xpath("//div[@class='ad_cclk']/h3/a")).getSelectedText();
        //Работает,но странно
        //String foo = $(By.xpath("//*[@id='vn1s0p1c0']")).getText();
        //Работает, но странно
        //String foo = $(By.xpath("//div[@class='ad_cclk']/h3")).getText();
        //System.out.println(foo);

        //fixme: Ищем вхождение слова Мерседес-Бенц. Как быть?
        // находит элемент по подстроке
        //$(withText("хаб")).shouldHave(text("Привет, хабр!"));
        $(withText("«Мерседес-Бенц")).shouldHave(text("«Мерседес-Бенц» GLS | в «Олимп Нева» | mercedes-olimp-neva.ru"));
    }
}
