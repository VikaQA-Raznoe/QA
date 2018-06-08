package ru.lesson.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//СТРАНИЦА 4: Thank you for your purchase today!
public class PurchasePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='table']/tbody")
    private List<WebElement> resultTable;

    @FindBy(css = "table.table tbody tr:nth-of-type(1) td:nth-of-type(2)")
    private WebElement idLabel;

    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)")
    private WebElement statusLabel;

    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)")
    private WebElement amountLabel;

    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")
    private WebElement cardNumber;

    @FindBy(css = "table.table tbody tr:nth-of-type(5) td:nth-of-type(2)")
    private WebElement expiration;

    @FindBy(css = "table.table tbody tr:nth-of-type(6) td:nth-of-type(2)")
    private WebElement authCodeLabel;

    @FindBy(css = "table.table tbody tr:nth-of-type(7) td:nth-of-type(2)")
    private WebElement currentDate;

    public WebElement getCurrentDate() {
        return currentDate;
    }

    public WebElement getAuthCode() {
        return authCodeLabel;
    }

    public WebElement getExpiration() {
        return expiration;
    }

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public WebElement getAmountLabel() {
        return amountLabel;
    }

    public WebElement getStatusLabel() {
        return statusLabel;
    }

    public WebElement getIdLabel() {
        return idLabel;
    }

    public List<WebElement> getResultTable() {
        return resultTable;
    }

    public void showResultTable(){
        for (WebElement elementFromTableResult:getResultTable()) {
            System.out.println("Таблица с результатами: " + elementFromTableResult.getText());
        }
    }

    public PurchasePage(WebDriver driver) {
        super(driver);
    }
}
