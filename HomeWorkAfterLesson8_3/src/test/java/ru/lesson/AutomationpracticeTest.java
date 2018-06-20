package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.automationpractice.pages.main.MainPage;

public class AutomationpracticeTest extends BaseTest {
    @Test
    public void test(){
        MainPage mainPage = new MainPage();
        mainPage.mouseUpSizeColorWomenButton();
    }
}
