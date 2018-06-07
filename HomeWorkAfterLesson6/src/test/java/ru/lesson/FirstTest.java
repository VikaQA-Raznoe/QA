package ru.lesson;

import org.testng.annotations.Test;
import ru.lesson.pages.PurchasePage;
import ru.lesson.pages.ReservedPage;
import ru.lesson.pages.ResultOfSelectionOfItemsPage;
import ru.lesson.pages.WelcomePage;

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
    public void test1(){

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
        //ЗАПОЛНИТЬ ЛЮБЫМИ ДАННЫМИ ПОЛЯ
        //fixme: Вынести в propeties
        reservedPage.inputTextIntoInput("Ivanov Ivan",
                "Sennaya Square 13-13",
                "Saint-Petersburg",
                "Russia","851127",
                "amex",
                //fixme:это значение нужно еще раз, для сравнения
                "5469 5478 5500 2631",
                "11",
                "2017",
                "Ivanov Ivan");

        //fixme:потом убрать - это одна из переменных, которую нужно вынести в property
        String tempCardNumber = "5469 5478 5500 2631";
        String tempCreditCardMonth = "11";
        String tempCreditCardYear = "2017";


        PurchasePage purchasePage = reservedPage.submitpPurchaseFlightButton();
        purchasePage.showResultTable();

        //ПРОВЕРКА ДАННЫХ
        //Налчие Id
        assertTrue(purchasePage.getIdLabel().getText().length() > 0);
        //Наличие Status
        //fixme:Посмотреть что-то c ExpectedConditions
        assertTrue(purchasePage.getStatusLabel().isDisplayed());
        //USD?
        System.out.println(purchasePage.getAmountLabel().getText());
        assertEquals("USD",purchasePage.getAmountLabel().getText().trim());
        //check Card Number
        assertEquals(tempCardNumber.trim().substring(15,19),purchasePage.getCardNumber().getText().trim().substring(12,16));
        //check Expiration: Month
        assertEquals(tempCreditCardMonth.trim(),purchasePage.getExpiration().getText().substring(0,2));
        //check Expiration: Year
        //fixme:Дата не генерится - это БАГ?
        assertEquals(tempCreditCardYear.trim(),purchasePage.getExpiration().getText().substring(4,8));
        //check AuthCode
        assertTrue(purchasePage.getAuthCode().isDisplayed());
        //check Date
        //fixme: Тест упадет,т.к дата на последней странице сгенерирована раз и не меняется - это БАГ?

    }
}
