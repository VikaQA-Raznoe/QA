package ru.lesson.yandex.pages.search.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lesson.utills.WebDriverManager;
import ru.lesson.yandex.components.IComponent;

import static ru.lesson.utills.WebDriverManager.getDriver;

public class EmailBlock implements IComponent {

    private final static By EMAIL_BLOCK = By.xpath("//div[role='form']"); //TODO Java Codestyle Russian
    private final static By ENTER_TO_EMAIL_BUTTON = By.xpath("./a[contains(@class,'login-enter')]");

    public void clickOnEnterToEmailButton() {
        WebElement emailButton = getDriver().findElement(ENTER_TO_EMAIL_BUTTON);
        emailButton.click();
    }

    //TODO Исправить модификатор на private
    public WebElement getRootElement() {
        return getDriver().findElement(EMAIL_BLOCK);
    }
}
