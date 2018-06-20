package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.blazedemo.pages.login.BlazedemoLogin;


public class BlazedemoLoginTest extends BaseTest{
    @Test
    public void test(){
        BlazedemoLogin blazedemoLogin = new BlazedemoLogin();
        blazedemoLogin.mouseUpLoginButton();
    }
}
