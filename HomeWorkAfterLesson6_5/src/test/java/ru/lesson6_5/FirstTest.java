package ru.lesson6_5;

import org.testng.annotations.Test;
import ru.lesson6_5.page.ResultOfSelectionOfItemsPage;
import ru.lesson6_5.page.WelcomePage;

public class FirstTest extends BaseTest {

    //fixme:Перенести данные в property
    //ДАННЫЕ ДЛЯ СРАВНЕНИЯ, ДЛЯ СТРАНИЦЫ: Welcome to the Simple Travel Agency!
    String textFromPort = "Paris";
    //Индекс столбца с пунктом отправления - Paris
    int columnDeparture = 3;

    String textToPort = "Buenos Aires";
    //Индекс столбца с нужныи заголовком - BuenosAeris
    int columnArrives = 4;

    @Test
    public void testWelcomePage(){
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.setFromPort(textFromPort);
        welcomePage.setToPort(textToPort);
        ResultOfSelectionOfItemsPage rosoip = welcomePage.submitFindFlightsButton();
        System.out.println(rosoip.getTitlePage().getText());
    }
}