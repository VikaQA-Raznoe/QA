package ru.lesson.blazedemo.pages.login.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lesson.blazedemo.components.IComponent;

public class LoginBlock2 implements IComponent {

    private final static By LOGIN_BLOCK = By.cssSelector(".panel-body");
    private final static By LOGIN_BUTTON = By.cssSelector(".form-group button");

    //Размер кнопки

    @Override
    public WebElement getRootElement() {
        return null;
    }
}
