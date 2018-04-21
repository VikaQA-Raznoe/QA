package ru.lesson6_5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage extends AbstractPage {

    //fixme: вынести пока в property
    //Пункт отправления
    String textFromPort = "Paris";
    //Пункт назначения
    String textToPort = "Buenos Aires";

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(css = "input")
    private WebElement findFlightsButton;


    public void setFromPort(String fromPort) {
        //Var-1
        //this.fromPort.sendKeys(fromPort);
        //Var-2
        Select selectFromPort = new Select(this.fromPort);
        selectFromPort.selectByVisibleText(textFromPort);
    }

    public void setToPort(String toPort) {
        //Var-1
        //this.toPort.sendKeys(toPort);
        //Var-2
        Select selectToPort = new Select(this.toPort);
        selectToPort.selectByVisibleText(textToPort);
    }

    public ResultOfSelectionOfItemsPage submitFindFlightsButton(){
        findFlightsButton.click();
        return new ResultOfSelectionOfItemsPage(driver);
    }

    public WelcomePage(WebDriver driver) {
        super(driver);
    }


}

