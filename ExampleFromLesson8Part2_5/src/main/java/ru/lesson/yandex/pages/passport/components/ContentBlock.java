package ru.lesson.yandex.pages.passport.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lesson.DriverManager;
import ru.lesson.yandex.components.IComponent;

public class ContentBlock implements IComponent {

    private final static By CONTENT_BLOCK = By.xpath("//div[contains(@class, 'passport-Page-Content')]");
    private final static By LOGIN_INPUT = By.name("login");
    //private final static By SIGN_IN_BUTTON = By.id("");
    private final static By SIGN_IN_BUTTON = By.cssSelector("#root > div > div.passport-Page-Content > div.passport-Domik > div > div > div > div > div > form > div:nth-child(13) > button > span > span");

    public void inputToLogin(String loginName){
        WebElement inputLogin = getRootElement().findElement(LOGIN_INPUT);
        inputLogin.sendKeys(loginName);
    }

    public WebElement getRootElement() {
        //return null;
        //return getDriver().findElement(CONTENT_BLOCK);
        return DriverManager.getDriver().findElement(CONTENT_BLOCK);
    }

    public boolean isContentBlockDisplayed(){
        return getRootElement().isDisplayed();
    }

    public String getSignInButtonBackgroundColor(){
        WebElement signButton = getRootElement().findElement(SIGN_IN_BUTTON);
        return signButton.getCssValue("background-color");
    }
}
