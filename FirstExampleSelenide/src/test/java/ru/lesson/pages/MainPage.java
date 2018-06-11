package ru.lesson.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    //@FindBy(css = "#mailbox\\:login")
    @FindBy(how = How.CSS, using = "#mailbox\\:login")
    WebElement loginInput;

    @FindBy(xpath = "//*[@id = 'mailbox:password']")
    SelenideElement password;

    public MainPage enterToMainPage(){
        return open("https://mail.ru/",MainPage.class);
    }

    public MainPage inputToLogin(String login){
        //$("#mailbox\\:login").setValue(login);
        //loginInput.setValue(login);
        loginInput.sendKeys(login);
        return this;
    }

    public MainPage inputToPassword(String password){
        this.password.setValue(password);
        return this;
    }

    public EmailMainPage clickOnButtonLogin(){
        $("#mailbox\\:submit").click();
        return page(EmailMainPage.class);

    }
}
