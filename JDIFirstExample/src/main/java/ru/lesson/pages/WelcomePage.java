package ru.lesson.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/")
public class WelcomePage extends WebPage {

    @Css("input")
    public static Button findFlightsButton;

    @Step
    public static void clickButton(){
        findFlightsButton.click();
    }
}