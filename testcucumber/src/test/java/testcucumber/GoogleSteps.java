package testcucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class GoogleSteps {
    private WebDriver driver;

    @Given("^I am on the Google search page$")
    public void i_am_on_the_google_search_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @When("^I search for \"(.*)\"$")
    public void i_search_for(String query){
        driver.findElement(By.name("q")).sendKeys(query);
    }

    @And("^I click button_enter$")
    public void i_click_button_enter(){
        WebElement butt = driver.findElement(By.cssSelector("#tsf > div.tsf-p > div.jsb > center > input[type=\"submit\"]:nth-child(1)"));
        butt.click();
    }

    @Then("The page title contains \"(.*)\"")
    public void the_page_contains(String word){
        //WebElement element = driver.findElement(By.cssSelector("div[@id=resultStats]"));
        /*WebElement element = new WebDriverWait(driver,10)
                .until
                        (ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("div[@id=resultStats]"))));*/
        WebElement element = new WebDriverWait(driver,10)
                .until(
                        ExpectedConditions.visibilityOf(driver.findElement(By.id("rso"))));
        Assert.assertTrue(driver.getTitle().contains(word));
    }

    @After
    public void close(){
        driver.quit();
    }

}
