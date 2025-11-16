package ru.neoflex;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    private static final String SEARCH_INPUT = "[name=q]";
    private static final String RESULT_LINK = "[href*='https://selenide.org']";

    @Test
    void successfulSearchTest() {
        open("https://www.duckduckgo.com/");
        $(SEARCH_INPUT).setValue("selenide").pressEnter();
        $(RESULT_LINK).shouldHave(text("https://selenide.org"));
    }
}