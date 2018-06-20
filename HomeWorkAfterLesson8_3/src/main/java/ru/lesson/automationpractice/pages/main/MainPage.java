package ru.lesson.automationpractice.pages.main;

import ru.lesson.AbstractPage;
import ru.lesson.automationpractice.pages.main.components.TopMenuBlock;

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
