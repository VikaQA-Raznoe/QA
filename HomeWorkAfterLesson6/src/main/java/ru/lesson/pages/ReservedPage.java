package ru.lesson.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class ReservedPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='container']/following::p[position()='2']")
    private WebElement flightNumberText;

    //@FindBy(xpath = "//*[@class='container']/following::p[position()='3']")
    @FindBy(css = "div.container:nth-child(2) > p:nth-child(4)")
    private WebElement priceText;

    //@FindBy(css = "div.container:nth-child(2) > p:nth-child(5)")
    @FindBy(xpath = "//*[@class='container']/following::p[position()='4']")
    private WebElement arbitraryText;

    @FindBy(css = "div.container:nth-child(2) > p:nth-child(7) > em:nth-child(1)")
    private WebElement totalCostText;

    @FindBy(xpath = "//*[@id='inputName']")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id='address']")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@id='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//*[@id='zipCode']")
    private WebElement zipCodeInput;

    @FindBy(id = "cardType")
    private WebElement cardTypeInput;

    @FindBy(xpath = "//*[@id='creditCardType']")
    private WebElement creditCardTypeSelect;

    @FindBy(xpath = "//*[@id='creditCardNumber']")
    private WebElement creditCardNumberInput;

    @FindBy(xpath = "//*[@id='creditCardMonth']")
    private WebElement creditCardMonthInput;

    @FindBy(xpath = "//*[@id='creditCardYear']")
    private WebElement creditCardYearInput;

    @FindBy(xpath = "//*[@id='nameOnCard']")
    private WebElement nameOnCardInput;

    //@FindBy(xpath = "//*[@class = 'controls']/following::input")
    @FindBy(css = "input.btn")
    private WebElement purchaseFlightButton;

    //Текущая дата, нужна для сравнения с датой на странице PurchasePage
    Date dateSystem;

    public Date getDateSystem() {
        return dateSystem;
    }

    public WebElement getPurchaseFlightButton() {
        return purchaseFlightButton;
    }

    public WebElement getNameOnCardInput() {
        return nameOnCardInput;
    }

    public WebElement getCreditCardYearInput() {
        return creditCardYearInput;
    }

    public WebElement getCreditCardMonthInput() {
        return creditCardMonthInput;
    }

    public WebElement getCreditCardNumberInput() {
        return creditCardNumberInput;
    }

    public WebElement getCreditCardTypeSelect() {
        return creditCardTypeSelect;
    }

    public WebElement getCardTypeInput() {
        return cardTypeInput;
    }

    public WebElement getZipCodeInput() {
        return zipCodeInput;
    }

    public WebElement getStateInput() {
        return stateInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getAddressInput() {
        return addressInput;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getTotalCostText() {
        return totalCostText;
    }

    public WebElement getArbitraryText() {
        return arbitraryText;
    }

    public WebElement getFlightNumberText() {
        return flightNumberText;
    }

    public WebElement getPriceText() {
        return priceText;
    }

    public void inputTextIntoInput(String name, String address,String city,String state,String zipCode,
                                   String creditCardType,String creditCardNumber,String creditCardMonth,
                                   String creditCardYear,String nameOnCard) {
        getNameInput().clear();
        getNameInput().sendKeys(name);
        getAddressInput().clear();
        getAddressInput().sendKeys(address);
        getCityInput().clear();
        getCityInput().sendKeys(city);
        getStateInput().clear();
        getStateInput().sendKeys(state);
        getZipCodeInput().clear();
        getZipCodeInput().sendKeys(zipCode);
        Select selectCardType = new Select(cardTypeInput);
        selectCardType.selectByValue(creditCardType);
        getCreditCardNumberInput().clear();
        getCreditCardNumberInput().sendKeys(creditCardNumber);
        getCreditCardMonthInput().clear();
        getCreditCardMonthInput().sendKeys(creditCardMonth);
        getCreditCardYearInput().clear();
        getCreditCardYearInput().sendKeys(creditCardYear);
        getNameOnCardInput().clear();
        getNameOnCardInput().sendKeys(nameOnCard);
    }

    public PurchasePage submitpPurchaseFlightButton(){
        this.dateSystem = new Date();
        getPurchaseFlightButton().click();
        return new PurchasePage(driver);
    }

    public ReservedPage(WebDriver driver) {
        super(driver);
    }
}
