package ru.lesson.yandex.pages.passport;

import ru.lesson.BasePage;
import ru.lesson.yandex.pages.passport.components.ContentBlock;

public class PassportPage extends BasePage {
    ContentBlock contentBlock;

    public void inputToContentBlockLogin(String login){
        contentBlock = new ContentBlock();
        contentBlock.inputToLogin(login);
    }

    public boolean isContentBlockDisplayed(){
        contentBlock = new ContentBlock();
        return contentBlock.isContentBlockDisplayed();
    }

    public String getSignInBacgroundColor(){
        contentBlock = new ContentBlock();
        return contentBlock.getSignInButtonBackgroundColor();
    }
}
