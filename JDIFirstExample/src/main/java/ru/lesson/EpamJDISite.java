package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.lesson.pages.ResultOfSelectionOfItemsPage;
import ru.lesson.pages.WelcomePage;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(value = "http://blazedemo.com/")
public class EpamJDISite extends WebSite {

    @JPage(url = "http://blazedemo.com/")
    public static WelcomePage welcomePage;

    @JPage(url = "http://blazedemo.com/reserve.php")
    public static ResultOfSelectionOfItemsPage resultOfSelectionOfItemsPage;

    @Css("input")
    public static Button findFlightsButton;
    @Step
    public static void chooseItemClickButton(){
        findFlightsButton.click();
        resultOfSelectionOfItemsPage.open();
    }

}
