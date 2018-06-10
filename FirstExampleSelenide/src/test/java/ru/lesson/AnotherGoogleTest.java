package ru.lesson;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class AnotherGoogleTest {
    @Test
    public void user_can_search_everything_in_google() {
        open("http://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();

        $$("#ires .g").shouldHave(size(10));

        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org"));
    }
}
