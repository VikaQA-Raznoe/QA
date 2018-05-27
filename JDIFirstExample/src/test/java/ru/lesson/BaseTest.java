package ru.lesson;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;

//IntiTests
public class BaseTest extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(EpamJDISite.class);
        //init(EpamSite.class);
        //EpamSite.open();
        //open();
        //login.submit(User.DEFAULT);
        //Verify.getFails();
        //logger.info("Run Tests");
    }

    /*@AfterMethod
    public void tearDown() {
        Verify.getFails();
    }*/
}