package ru.lesson.yandex.pages.passport;

import ru.lesson.AbstractPage;
import ru.lesson.yandex.pages.passport.components.ContentBlock;

public class PassportPage extends AbstractPage {
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
