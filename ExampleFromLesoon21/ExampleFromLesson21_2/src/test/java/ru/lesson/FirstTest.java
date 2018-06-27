package ru.lesson;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.lesson.utills.TestListener;


import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class FirstTest extends BaseTest {
    @Test
    public void test(){
        //Делаем скриншот страницы, на которую заходим
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target\\screeshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(false);
    }
}