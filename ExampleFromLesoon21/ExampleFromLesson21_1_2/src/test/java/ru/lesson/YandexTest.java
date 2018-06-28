package ru.lesson;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.lesson.helpers.TakeScreenshot.takeScreenshot;

public class YandexTest extends BaseTest {
    @Test
    public void test(){

    }

    private void assertTrue(boolean condition){
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError error){
            takeScreenshot(driver);
            error.printStackTrace();
        }
    }
}
