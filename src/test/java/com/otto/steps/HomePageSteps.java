package com.otto.steps;

import com.codeborne.selenide.Condition;
import com.otto.pages.HomePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.open;

public class HomePageSteps implements En {

HomePage homePage;
String baseUrl = "https://www.otto.de/";

public HomePageSteps() {

    Given("that we navigate to home page", () -> {
        homePage = open(baseUrl, HomePage.class);
    });

    When("we accept cookies", () -> {
        homePage.acceptCookies();
    });

    When("we press Mein Konto icon", () -> {
        homePage.goToMeinKonto();
    });

    Then("user icon shows that we're logged in", () -> {
        homePage.verifyAuthIcon().shouldBe(Condition.visible);
    });
}
}
