package ru.lesson.yandex.pages.search.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lesson.DriverManager;
import ru.lesson.yandex.components.IComponent;

public class EmailBlock implements IComponent {

    private final static By EMAIL_BLOCK = By.xpath("//div[role='form']"); //TODO Java Codestyle Russian
    //private final static By ENTER_TO_EMAIL_BUTTON = By.xpath("./a[contains(@class,'login-enter')]");
    private final static By ENTER_TO_EMAIL_BUTTON = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div/a[1]");

    public void clickOnEnterToEmailButton() {
        //WebElement emailButton = getDriver().findElement(ENTER_TO_EMAIL_BUTTON);
        //emailButton.click();

        WebElement emailButton = DriverManager.getDriver().findElement(ENTER_TO_EMAIL_BUTTON);
        emailButton.click();
    }

    //TODO Исправить модификатор на private
    public WebElement getRootElement() {
        //return null;
        //return getDriver().findElement(EMAIL_BLOCK);
        return DriverManager.getDriver().findElement(EMAIL_BLOCK);
    }
}
