package ru.lesson;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

public class DemoTest {
    private RemoteWebDriver driver;

    /*@Before
    public void openDriver() throws Exception{
        //final DesiredCapabilities browser = DesiredCapabilities.chrome();
        final DesiredCapabilities browser = DesiredCapabilities.firefox();
        browser.setCapability("enableVNC",true);
        browser.setCapability("screenResolution","1920x1024x24");
        //driver = new RemoteWebDriver(new URL("http://95.85.41.216:4444/wd/hub"),browser);
        driver = new RemoteWebDriver(new URL("http://192.168.100.8:8080/wd/hub"),browser);
    }*/

    @Before
    public void openDriver() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("latest");

        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
                //URI.create("http://localhost:4444/wd/hub").toURL(),capabilities);
                URI.create("http://192.168.100.8:8080/wd/hub").toURL(),capabilities);
    }

    @Test
    public void browserTest() throws Exception{
        try {
            Thread.sleep(3000);
            driver.get("http://duckduckgo.com/");
            WebElement input = driver.findElement(By.cssSelector("input#search_form_input_homepage"));
            input.sendKeys("selenium", Keys.ENTER);
            Thread.sleep(10000);
        } finally {
            takeScreenshot(driver);
        }
    }

    public void takeScreenshot(WebDriver driver) throws Exception{
        byte[] screen = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
        UUID uuid = UUID.randomUUID();
        FileUtils.writeByteArrayToFile(new File(uuid.toString() + ".png"),screen);
    }

    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
