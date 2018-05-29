package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;
import ru.lesson.utills.PropertyReader;

//IntiTests
public class BaseTest extends TestNGBase {

   /* private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String FROM_PORT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "fromPort");
    private static final String TO_PORT = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "toPort");*/

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(EpamJDISite.class);
    }
}