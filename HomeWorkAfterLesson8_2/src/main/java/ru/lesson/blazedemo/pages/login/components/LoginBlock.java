package ru.lesson.blazedemo.pages.login.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lesson.DriverManager;
import ru.lesson.blazedemo.components.IComponent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginBlock implements IComponent {

    private final static By LOGIN_BLOCK = By.cssSelector(".panel-body");
    private final static By LOGIN_BUTTON = By.cssSelector(".form-group button");

    @Override
    public WebElement getRootElement() {
        return DriverManager.getDriver().findElement(LOGIN_BLOCK);
    }

    public void clickOnLoginButton() {
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    //Пример использования Actions API:
    //1)Наводим указатель на элмент
    //2)Нажимаем кнопку мыши
    public void clickOnLoginButton2(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).click().build().perform();
    }

    //Пример использования JavascriptExecutor
    public void clickOnLoginButton3(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);"
                ;

        ((JavascriptExecutor)DriverManager.getDriver()).executeScript(script, loginButton);
    }


    //Наведение кнопки мыши на кнопку "Login" + проверка размера кнопки, проверка цвета кнопки после наведения
    public void mouseUpSizeButton2(){
        WebElement loginBeforeMouseUpButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        int heightButtonBefore = loginBeforeMouseUpButton.getSize().getHeight();
        int widthButtonBefore = loginBeforeMouseUpButton.getSize().getWidth();
        System.out.println("heightButtonBefore: " + heightButtonBefore);
        System.out.println("widthButtonBefore: " + widthButtonBefore);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginBeforeMouseUpButton).build().perform();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        WebElement loginAfterMouseUpButton = wait.until(ExpectedConditions.visibilityOf(loginBeforeMouseUpButton));
    }


    public String getButtonBackgroundColor(By by){
        WebElement button = getRootElement().findElement(by);
        return button.getCssValue("background-color");
    }

    public int getButtonHeight(By by){
        WebElement button = getRootElement().findElement(by);
        return button.getSize().getHeight();
    }

    public int getButtonWidth(By by){
        WebElement button = getRootElement().findElement(by);
        return button.getSize().getWidth();
    }

    //Наведение кнопки мыши на кнопку "Login" + проверка размера кнопки, проверка цвета кнопки после наведения
    public void mouseUpPropertiesButton2(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);

        //Свойства элемента(кнопки) до наведения мыши
        int heightButtonBefore = loginButton.getSize().getHeight();
        int widthButtonBefore = loginButton.getSize().getWidth();
        String backGroundColorButtonBefore = loginButton.getCssValue("background-color");

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).build().perform();

        //Свойства элемента(кнопки) после наведения мыши:
        int heightButtonAfter = loginButton.getSize().getHeight();
        int widthButtonAfter = loginButton.getSize().getWidth();
        //String backGroundColorButtonAfter = loginButton.getCssValue("background-color");
        Boolean backGroundColorButtonAfter = wait.until(ExpectedConditions.attributeContains(LOGIN_BUTTON,"background-color","rgba(37, 121, 169, 1)"));

        //Сравнение цвета кнопки после наведения мыши с ожидаемым цветом - Вариант 1
        //assertEquals(backGroundColorButtonAfter,"rgba(37, 121, 169)");
        //Сравнение цвета кнопки после наведения мыши с ожидаемым цветом - Вариант 2
        //fixme:При сравнение с rgba(37, 121, 169, 1) тест падает. Как правильно???? Вариант 1 или Вариант 2?
        assertEquals(backGroundColorButtonAfter,"rgba(37, 121, 169, 1)");
        //Проверка цвета кнопки после наведения мыши с использованием ExpectedConditions.attributeContains - Вариант 3
        assertTrue(backGroundColorButtonAfter);

        //Сравнение размеров кнопки, после наведения мыши, с первоначальными размерами
        assertEquals(heightButtonAfter,heightButtonBefore);
        assertEquals(widthButtonAfter,widthButtonBefore);
    }

    //Разделили метод
    //Метод наведения мышки на кнопку
    public void mouseUpButton(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).build().perform();
    }

    public void mouseUpHeightButton(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        //Свойства элемента(кнопки) до наведения мыши:
        int heightButtonBefore = loginButton.getSize().getHeight();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).build().perform();
        //Свойства элемента(кнопки) после наведения мыши:
        int heightButtonAfter = loginButton.getSize().getHeight();
        assertEquals(heightButtonBefore,heightButtonAfter);

    }


    public void mouseUpWidthButton(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        //Свойства элемента(кнопки) до наведения мыши:
        int widthButtonBefore = loginButton.getSize().getWidth();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).build().perform();
        //Свойства элемента(кнопки) после наведения мыши:
        int widthButtonAfter = loginButton.getSize().getWidth();
        assertEquals(widthButtonBefore,widthButtonAfter);
    }

    public void mouseUpColorButton(){
        WebElement loginButton = DriverManager.getDriver().findElement(LOGIN_BUTTON);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(loginButton).build().perform();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        assertEquals(loginButton.getCssValue("background-color"),"rgba(37, 121, 169, 1)");
    }
}
