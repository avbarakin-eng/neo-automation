package ru.neoflex;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTests {
    String url = Paths.get("src/test/resources/login.html").toUri().toString();

    // Вынесенные селекторы
    private static final String USERNAME_FIELD = "#username";
    private static final String PASSWORD_FIELD = "#password";
    private static final String LOGIN_BUTTON = "button[id='loginButton']";
    private static final String MESSAGE_FIELD = "[id=message]";

    @Test
    void successfulLoginTest() {
        open(url);
        $(USERNAME_FIELD).setValue("testuser");
        $(PASSWORD_FIELD).setValue("password123");
        $(LOGIN_BUTTON).click();
        $(MESSAGE_FIELD).shouldHave(text("Invalid username or password."));
    }

    @Test
    void emptyUsernameShowsErrorTest() {
        open(url);
        $(PASSWORD_FIELD).setValue("password123");
        $(LOGIN_BUTTON).click();
        $(MESSAGE_FIELD).shouldHave(text("Username is required."));
    }
}
