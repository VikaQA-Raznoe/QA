package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import ru.lesson.pages.WelcomePage;

@JSite(value = "http://blazedemo.com")
public class EpamJDISite extends WebSite {
    @JPage
    public static WelcomePage welcomePage;
}
