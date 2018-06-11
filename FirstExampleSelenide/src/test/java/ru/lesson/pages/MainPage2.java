package ru.lesson.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage2 {

    private By loginInput = By.cssSelector("#mailbox\\:login");
    private By passwordInput = By.xpath("//*[@id = 'mailbox:password']");

    public MainPage2 inputToLogin(String login){
        $(loginInput).setValue(login);
        return this;
    }

    public MainPage2 inputToPassword(String password) {
        $(passwordInput).setValue(password);
        return this;
    }

    public EmailMainPage clickOnButtonLogin(){
        $("#mailbox\\:submit").click();
        return page(EmailMainPage.class);

    }

    public MainPage2 enterToMainPage(){
        return open("https://mail.ru/",MainPage2.class);
    }
}
