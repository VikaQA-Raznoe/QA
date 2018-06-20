package ru.lesson.automationpractice.pages.login;

import ru.lesson.AbstractPage;
import ru.lesson.automationpractice.pages.login.components.TopMenuBlock;

public class MainPage extends AbstractPage {
    TopMenuBlock topMenuBlock;

    public void mouseUpSizeColorWomenButton(){
        topMenuBlock = new TopMenuBlock();
        topMenuBlock.mouseUpButton();
        topMenuBlock.mouseUpHeightButton();
        topMenuBlock.mouseUpWidthButton();
        topMenuBlock.mouseUpColorButton();
    }
}
