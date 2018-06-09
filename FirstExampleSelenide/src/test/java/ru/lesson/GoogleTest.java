package ru.lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

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
        //Проверить, что стираница содержит тег рузултатов поиска
        //$("#center_col").should(Condition.visible);
        //$("#tads > ol > li:nth-child(1)").should(Condition.visible);

        $(".ad_cclk").should(Condition.visible);
        //fixme: Как получить текст первой ссылки?
        String temp = $(".ad_cclk h3 a:child(2)").getText();
        System.out.println(temp);
        //Нажать на первую ссылку
        $(".ad_cclk h3").click();
        //fixme: Как нажать на третью ссылку??
    }
}
