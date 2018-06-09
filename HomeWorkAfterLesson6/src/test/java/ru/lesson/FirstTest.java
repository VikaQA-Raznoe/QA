package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.data.TestDataForFirstTest;
import ru.lesson.pages.PurchasePage;
import ru.lesson.pages.ReservedPage;
import ru.lesson.pages.ResultOfSelectionOfItemsPage;
import ru.lesson.pages.WelcomePage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    //ДАННЫЕ ДЛЯ СРАВНЕНИЯ, ДЛЯ СТРАНИЦЫ: Welcome to the Simple Travel Agency!
    String textFromPort = "Paris";
    //Индекс столбца с пунктом отправления - Paris
    int columnDeparture = 3;

    String textToPort = "Buenos Aires";
    //Индекс столбца с нужныи заголовком - BuenosAeris
    int columnArrives = 4;

    @Test
    public void test1() throws ParseException {

        //Класс с тестовыми данными
        TestDataForFirstTest testDataForFirstTest = new TestDataForFirstTest();

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.setFromPort(textFromPort);
        welcomePage.setToPort(textToPort);

        ResultOfSelectionOfItemsPage rosoip = welcomePage.submitFindFlightsButton();
        String numberFlight = rosoip.getNumberFlightText().getText();
        String cleanPrice = rosoip.getPriceText().getText().substring(1,rosoip.getPriceText().getText().trim().length());

        ReservedPage reservedPage = rosoip.submitChooseThisFlightButton();
        String numberFlightP = reservedPage.getFlightNumberText().getText().substring(15,reservedPage.getFlightNumberText().getText().trim().length());
        String priceP = reservedPage.getPriceText().getText().substring(6,reservedPage.getPriceText().getText().trim().length());
        String cleanArbitrary = reservedPage.getArbitraryText().getText().substring(26,reservedPage.getArbitraryText().getText().length());
        double totalPrice = Double.parseDouble(priceP) + Double.parseDouble(cleanArbitrary);
        String totalCost = reservedPage.getTotalCostText().getText();
        assertEquals(numberFlight.trim(),numberFlightP.trim());
        assertEquals(cleanPrice.trim(),priceP.trim());
        assertEquals(Double.parseDouble(totalCost),totalPrice);
        //ЗАПОЛНИТЬ ЛЮБЫМИ ДАННЫМИ ПОЛЯ - БЕРУТСЯ ИЗ КЛАССА TestDataForFirstTest
        reservedPage.inputTextIntoInput(testDataForFirstTest.getName(),
                testDataForFirstTest.getAddress(),
                testDataForFirstTest.getCity(),
                testDataForFirstTest.getState(),
                testDataForFirstTest.getZipCode(),
                testDataForFirstTest.getCreditCardType(),
                testDataForFirstTest.getCreditCardNumber(),
                testDataForFirstTest.getCreditCardMonth(),
                testDataForFirstTest.getCreditCardYear(),
                testDataForFirstTest.getNameOnCard());

        PurchasePage purchasePage = reservedPage.submitpPurchaseFlightButton();
        //purchasePage.showResultTable();

        //ПРОВЕРКА ДАННЫХ
        //Наличие Id
        assertTrue(purchasePage.getIdLabel().getText().length() > 0);
        //Наличие Status
        //fixme:Посмотреть что-то c ExpectedConditions
        assertTrue(purchasePage.getStatusLabel().isDisplayed());
        //check USD
        assertEquals("USD",purchasePage.getAmountLabel().getText().trim());
        //check Card Number
        assertEquals(testDataForFirstTest.getCreditCardNumber().substring(testDataForFirstTest.getCreditCardNumber().length() - 4)
                ,purchasePage.getCardNumber().getText().substring(purchasePage.getCardNumber().getText().length() -4)
        );
        //check Expiration: Month
        //assertEquals(testDataForFirstTest.getCreditCardMonth().trim(),purchasePage.getExpiration().getText().substring(0,2));
        assertEquals(testDataForFirstTest.getCreditCardMonth().trim(),
                purchasePage.getExpiration().getText().substring(purchasePage.getExpiration().getText().length()
                        -purchasePage.getExpiration().getText().length(),purchasePage.getExpiration().getText().length()-6).trim()
        );

        //check Expiration: Year
        //assertEquals(testDataForFirstTest.getCreditCardYear().trim(),purchasePage.getExpiration().getText().substring(4,8));
        assertEquals(testDataForFirstTest.getCreditCardYear().trim(),purchasePage.getExpiration().getText().substring(purchasePage.getExpiration().getText().length()-4).trim());

        //check AuthCode
        assertTrue(purchasePage.getAuthCode().isDisplayed());

        //check Date
        //Сравнение даты генерируемой системой  и даты, которая отображается на странице
        SimpleDateFormat formatter2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        long pageTime= formatter2.parse(purchasePage.getCurrentDate().getText()).getTime();
        //System.out.println(pageTime);
        //System.out.println(reservedPage.getDateSystem().getTime());
        assertTrue((reservedPage.getDateSystem().getTime() - pageTime)< 10000 );
    }
}
