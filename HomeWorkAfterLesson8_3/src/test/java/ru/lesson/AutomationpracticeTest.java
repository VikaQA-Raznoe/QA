package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.automationpractice.pages.login.MainPage;
import ru.lesson.automationpractice.pages.login.components.TopMenuBlock;

public class AutomationpracticeTest extends BaseTest {
    @Test
    public void test(){
        MainPage mainPage = new MainPage();
        mainPage.mouseUpSizeColorWomenButton();
    }
}
