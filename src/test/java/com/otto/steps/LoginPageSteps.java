package com.otto.steps;

import com.otto.pages.LoginPage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageSteps implements En {

    LoginPage loginPage;

    public LoginPageSteps() {
        Then("we see a login form", () -> {
            loginPage = page(LoginPage.class);
            loginPage.formIsShown().shouldHave( text("Deine Anmeldedaten") );
        } );

        When("we enter valid creds of existing user", () -> {
            loginPage.validAuth();
        });

        And("we submit this form", () -> {
            loginPage.submit();
        });

        Given("we're logged in", () -> {
            loginPage = page(LoginPage.class);
            loginPage.formIsShown().shouldHave( text("Deine Anmeldedaten") );
            loginPage.validAuth();
            loginPage.submit();
        });

    }
}
