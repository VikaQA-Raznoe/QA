package testcucumber;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
        //driver.findElement(By.name("q")).sendKeys(query);
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(query);
        //Нажимаем кнопку "Enter"
        searchInput.submit();
    }

    @Then("The page title contains \"(.*)\"")
    public void the_page_title_contains(String word){
        //ВАРИАНТ 1:
        //Проверяем вхождение слова word в тег title страницы
        Assert.assertTrue(driver.getTitle().contains(word));

        //ВАРИАНТ 2:
        //Ждем пока загрузится страница с результатами
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        //Элемент содержит список найденных результатов
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
        //Просмотр все загруженных ссылок-результов
        for (WebElement webElement : findElements)
        {
            //ВАРИАНТ 2-1:
            //System.out.println(webElement.getAttribute("href"));
            //Проверяем есть ли в ссылкке вхождение слова word
            //System.out.println(webElement.getAttribute("href").toUpperCase().contains(word.toUpperCase()));

            //ВАРИАНТ 2-2:
            //System.out.println(webElement.getText());
            //Проверяем входит ли в текст ссылки слово word
            //System.out.println(webElement.getText().toUpperCase().contains(word.toUpperCase()));
        }

        //Нажимаем на третью ссылку
        driver.findElement(By.xpath("(//h3[@class='r']/a)[3]")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
