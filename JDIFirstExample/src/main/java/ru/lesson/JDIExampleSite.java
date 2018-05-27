package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@JSite(value = "http://blazedemo.com/")
public class JDIExampleSite extends WebSite {
    public static ResultOfSelectionOfItemsPage resultOfSelectionOfItemsPage;

    //@FindBy(name = "fromPort")
    //public static WebElement fromPort;\
    //public static DropList fromPort;

    //@FindBy(name = "toPort")
    //public static WebElement toPort;

    @FindBy(css = "input")
    public static Button findFlightsButton;

    public static void clickButton(){
        findFlightsButton.click();
    }

}
