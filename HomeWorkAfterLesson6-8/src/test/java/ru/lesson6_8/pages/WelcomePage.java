package ru.lesson6_8.pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lesson6_8.utils.Driver;

import static org.junit.Assert.assertTrue;

public class WelcomePage{


    @Step("Click on the button Find Flights")
    public void submitButton(){
        WebElement findFlightsButton = Driver.webDriver.findElement(By.cssSelector("input.btn"));
        assertTrue(findFlightsButton.isEnabled());
    }
}
