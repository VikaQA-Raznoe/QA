package ru.lesson.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/")
public class WelcomePage extends WebPage {

    //@Css("input")
    //public Button findFlightsButton;

    @FindBy(css = "[type='submit']")
    public Button findFlightsButton;

    @Step
    public void selectCitiesAndSubmitForm(){
        this.findFlightsButton.click();
    }
}