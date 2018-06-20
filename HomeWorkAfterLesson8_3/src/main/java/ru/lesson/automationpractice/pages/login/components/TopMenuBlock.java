package ru.lesson.automationpractice.pages.login.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lesson.DriverManager;
import ru.lesson.automationpractice.components.IComponent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TopMenuBlock implements IComponent{
    private final static By TOP_MENU_BLOCK = By.cssSelector("#block_top_menu");
    private final static By WOMEN_BUTTON = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");

    @Override
    public WebElement getRootElement() {
        return DriverManager.getDriver().findElement(TOP_MENU_BLOCK);
    }

    //Метод наведения мышки на кнопку
    public void mouseUpButton(){
        WebElement womenButton = DriverManager.getDriver().findElement(WOMEN_BUTTON);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(womenButton).build().perform();
    }

    //Проверка высоты кнопки "Login"
    public void mouseUpHeightButton(){
        WebElement womenButton = DriverManager.getDriver().findElement(WOMEN_BUTTON);
        //Свойства элемента(кнопки) до наведения мыши:
        int heightButtonBefore = womenButton.getSize().getHeight();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(womenButton).build().perform();
        //Свойства элемента(кнопки) после наведения мыши:
        int heightButtonAfter = womenButton.getSize().getHeight();
        assertEquals(heightButtonBefore,heightButtonAfter);

    }

    //Проверка ширины кнопки "Login"
    public void mouseUpWidthButton(){
        WebElement womenButton = DriverManager.getDriver().findElement(WOMEN_BUTTON);
        //Свойства элемента(кнопки) до наведения мыши:
        int widthButtonBefore = womenButton.getSize().getWidth();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(womenButton).build().perform();
        //Свойства элемента(кнопки) после наведения мыши:
        int widthButtonAfter = womenButton.getSize().getWidth();
        assertEquals(widthButtonBefore,widthButtonAfter);
    }

    //Проверка цвета кнопки "Login"
    //Цвет после наведения мыши должен быть 51,51,51,1
    //Перед сравнением нужно в онлайн-переводчике перевести из rgba(51,51,51,1) в rgb(51,51,51)
    //Т.к womenButton.getCssValue("background-color") возвращает цвет в формате RGB
    public void mouseUpColorButton(){
        WebElement womenButton = DriverManager.getDriver().findElement(WOMEN_BUTTON);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(womenButton).build().perform();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        Boolean backGroundColorButtonAfter = wait.until(ExpectedConditions.attributeContains(WOMEN_BUTTON,"background-color","rgb(51, 51, 51)"));
        assertTrue(backGroundColorButtonAfter);
    }
}
