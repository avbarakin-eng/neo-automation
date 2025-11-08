import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.WebDriverRunner;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        openSite();
        $("input[name='g']").setValue("ga.guru").pressEnter();
        checkResult("https://qa.guru");
    }

    @Test
    void successfulClickTest() {
        openSite();
        $("input[name='g']").setValue("ga.guru");
        $("[theme='outer']").click();
        checkResult("https://qa.guru");
    }

    void openSite() {
        open("https://www.google.com/");
    }

    void checkResult(String value) {
        $("#search").shouldHave(text(value));
        // Альтернатива: проверка URL
        // assertEquals(value, WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
