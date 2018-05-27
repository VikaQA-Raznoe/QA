package ru.lesson.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/reserve.php")
public class ResultOfSelectionOfItemsPage extends WebPage {


    @Css("tr:nth-child(3) > td:nth-child(2) > input")
    public static Button chooseThisFlightButton;

    @Step
    public static void clickButtonChooseThisFlightButton(){
        chooseThisFlightButton.click();
    }
}
