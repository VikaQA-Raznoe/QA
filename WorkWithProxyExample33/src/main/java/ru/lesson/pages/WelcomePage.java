package ru.lesson.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.support.FindBy;
import ru.lesson.utills.PropertyReader;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/", title = " BlazeDemo")
public class WelcomePage extends WebPage {

    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/data.properties";

    //ВАРИАНТ 1 ОБРАЩЕНИЯ К ЭЛМЕНТУ КНОПКА
    @Css("input")
    public Button findFlightsButton;

    //ВАРИАНТ 2 ОБРАЩЕНИЯ К ЭЛМЕНТУ КНОПКА
    //@FindBy(css = "[type='submit']")
    //public Button findFlightsButton;

    @FindBy(css = "[name='fromPort']")
    //@FindBy(name = "fromPort")
    public Selector departureCity;

    @FindBy(css = "[name='toPort']")
    //@FindBy(name = "toPort")
    public Selector destinationCity;

    @Step
    public void selectCitiesAndSubmitForm(){
        this.departureCity.select(PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,"fromPort"));
        this.destinationCity.select(PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,"toPort"));
        this.findFlightsButton.click();
    }
}