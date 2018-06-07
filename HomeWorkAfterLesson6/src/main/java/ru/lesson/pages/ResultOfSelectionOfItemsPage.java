package ru.lesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultOfSelectionOfItemsPage extends AbstractPage {

    //Третья кнопка в первом столбце
    @FindBy(css = "tr:nth-child(3) > td:nth-child(2) > input")
    private WebElement chooseThisFlightButton;

    //Number Flight: 9696
    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(3)")
    private WebElement numberFlightText;

    //Airline: Aer Lingus
    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(7)")
    WebElement priceText;



    public WebElement getPriceText() {
        return priceText;
    }

    public WebElement getChooseThisFlightButton() {
        return chooseThisFlightButton;
    }

    public WebElement getNumberFlightText() {
        return numberFlightText;
    }

    public ReservedPage submitChooseThisFlightButton(){
        getChooseThisFlightButton().click();
        return new ReservedPage(driver);
    }

    public ResultOfSelectionOfItemsPage(WebDriver driver) {
        super(driver);
    }
}
