package ru.lesson;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ThirdTest extends BaseTest {
    @Test
    public void test(){
        String text = driver.findElement(By.tagName("html")).getText();

        System.out.println(text);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile,new File("screenshoot.png"));
        } catch (IOException e){

        }
    }
}