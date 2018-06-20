package ru.lesson.blazedemo.pages.login;

import ru.lesson.AbstractPage;
import ru.lesson.blazedemo.pages.login.components.LoginBlock;


public class BlazedemoLogin extends AbstractPage{

    LoginBlock loginBlock;

    public void enterLoginPage(){
        loginBlock = new LoginBlock();
        //Нажимаем на кнопку "Login" тремя разными способами
        //loginBlock.clickOnLoginButton();
        //loginBlock.clickOnLoginButton2();
        //loginBlock.clickOnLoginButton3();
        //Наводим мышку на кнопку "Login" и смотрим свойства кнопки
        loginBlock.mouseUpPropertiesButton2();
    }
}
