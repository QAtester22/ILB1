package com.otto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static By okCookiesButton = By.cssSelector("#cookieBanner > div > div > div.cookieBanner__footer > button");
    private static By meinKontoIcon = By.cssSelector("[data-qa='user_login_area_header_container']");
    private static By anmeldenButton = By.cssSelector("[data-qa='user_login_area_login']");
    private static By loggedInIcon = By.cssSelector("[data-qa='user_login_area_badge_logged_in']");
    public void acceptCookies() {
        $(okCookiesButton).click();
    }

    public void goToMeinKonto() {
        $(meinKontoIcon).click();
        $(anmeldenButton).click();
    }
    public SelenideElement verifyAuthIcon() {
        return $(loggedInIcon);
    }
}
