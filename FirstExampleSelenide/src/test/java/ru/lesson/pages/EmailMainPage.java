package ru.lesson.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class EmailMainPage {
    public EmailMainPage checkVisible(){
        $("#b-letters").should(Condition.visible);
        return this;
    }
}
