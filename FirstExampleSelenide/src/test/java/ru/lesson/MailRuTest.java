package ru.lesson;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class MailRuTest
{
    @Test
    public void mailRuLoginTest(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        open("https://mail.ru/");
        $("#mailbox\\:login").setValue("neo-737");
        $x("//*[@id = 'mailbox:password']").setValue("qw99op");
        $("select.o-control").selectOptionContainingText("bk.ru");
        //$(By.cssSelector("#input.o-control")).click();
        $("#mailbox\\:submit").click();
        $("#b-letters").should(Condition.visible);
        //Проверка на то, сколько результатов на сттанице - сколько писем в ящике
        //$$("#b-letters. b-datalist__body > div").shouldHave(size(3));
        //Проверить текст
        $$("#b-letters. b-datalist__body > div").get(0).should(Condition.matchesText("hh"));
    }
}
