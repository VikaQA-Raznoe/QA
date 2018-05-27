package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.support.FindBy;
import ru.lesson.pages.ResultOfSelectionOfItemsPage;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(value = "http://blazedemo.com/")
public class JDIExampleSite extends WebSite {
    public static ResultOfSelectionOfItemsPage resultOfSelectionOfItemsPage;

    //@FindBy(name = "fromPort")
    //public static WebElement fromPort;\
    //public static DropList fromPort;

    //@FindBy(name = "toPort")
    //public static WebElement toPort;

    /*@Css("input")
    public static Button findFlightsButton;

    @Step
    public static void clickButton(){
        findFlightsButton.click();
    }*/

}
