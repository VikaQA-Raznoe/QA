package ru.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FirstTest extends BaseTest{

    @Test
    public void test1(){
        //---Chapter 1---
        System.out.println("Working test1()");
        webDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        WebElement radioButton = webDriver.findElement(By.id("radiobutton"));
        radioButton.click();
        assertTrue(radioButton.isDisplayed());
        //---Chapter 1---
    }

    @Test
    public void test2(){
        webDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        //---Chapetr 1---
        System.out.println("Working test2()");
        //radioButton
        /*WebElement radioButton = driver.findElement(By.id("radiobutton"));
        radioButton.click();
        assertTrue(radioButton.isDisplayed());*/

        //Выпадающий список.Выбор элемента
        WebElement selectElement = webDriver.findElement(By.id("selecttype"));
        Select select = new Select(selectElement);
        select.selectByValue("Selenium Grid");

        //Ожидаемый текс
        String expectedText = "The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";
        WebElement linkAjax = webDriver.findElement(By.cssSelector(".loadajax"));
        linkAjax.click();
        WebElement textAreaAjax = webDriver.findElement(By.id("ajaxdiv"));

        //Ждем загрузки(появления) элмента на странице
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(textAreaAjax,expectedText));
        assertEquals(textAreaAjax.getText(),expectedText);
        assertTrue(textAreaAjax.isDisplayed());
    }

    @Test
    public void test3(){
        webDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        System.out.println("Working test3()");
        //---Chapter 2---
        WebElement homePage = webDriver.findElement(By.partialLinkText("Home Page"));
        homePage.click();
        WebElement chapter2 = webDriver.findElement(By.partialLinkText("Chapter2"));
        chapter2.click();

        WebElement syblingButton = webDriver.findElement(By.xpath("//*[@id='but1']/following-sibling::input"));
        //---Chapter 2---

    }

    @Test
    public void test4(){
        System.out.println("Working test4()");
    }
}
