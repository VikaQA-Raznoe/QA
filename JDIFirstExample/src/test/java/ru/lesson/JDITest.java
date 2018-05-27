package ru.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import ru.lesson.pages.WelcomePage;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.open;
import static ru.lesson.EpamJDISite.chooseItemClickButton;
import static ru.lesson.pages.ResultOfSelectionOfItemsPage.clickButtonChooseThisFlightButton;

public class JDITest extends  BaseTest{

    @Test
    public void welcomePageTest(){
        //WebDriverManager.firefoxdriver().setup();
        open();
        chooseItemClickButton();
        clickButtonChooseThisFlightButton();
    }
}
