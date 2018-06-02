package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class FirstTest extends WebDriverManager {

    WebDriver driver = WebDriverManager.getDriver();

    @Test
    public void test1(){
        //---Chapter 1---
        System.out.println("Working test1()");
        //Почему-то временами блокируется - не открывается то в Chrome, то в Firefox
        driver.get("http://blazedemo.com");
        //driver.get("http://book.theautomatedtester.co.uk/chapter1");
        //---Chapter 1---
    }
}
