import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTests {
    String url = Paths.get("src/test/resources/login.html").toUri().toString();

    @Test
    void successfulLoginTest() {
        open(url);

        $("#username").setValue("testuser");
        $("#password").setValue("password123");
        $("button[id='loginButton']").click();

        $("[id=message]").shouldHave(text("Invalid username or password."));
    }

    @Test
    void emptyUsernameShowsErrorTest() {
        open(url);

        $("#password").setValue("password123");
        $("button[id='loginButton']").click();

        $("[id=message]").shouldHave(text("Username is required."));
    }
}