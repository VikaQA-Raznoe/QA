package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static ru.lesson.JDIExampleSite.resultOfSelectionOfItemsPage;
import static ru.lesson.pages.ResultOfSelectionOfItemsPage.clickButton;


public class JDITest extends  BaseTest{

    @Test
    public void welcomePageTest(){
        WebDriverManager.firefoxdriver().setup();
        resultOfSelectionOfItemsPage.findFlightsButton.click();
    }
}
