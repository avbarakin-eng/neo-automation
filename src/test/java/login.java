import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class login {
    @Test
    public void testSuccessfulLogin() {
        // 1. Открываем страницу входа
        Selenide.open("file:///path/to/your/login.html"); // замените на реальный URL

        // 2. Вводим корректные данные
        $(byName("username")).setValue("testuser");
        $(byName("password")).setValue("secret123");

        // 3. Нажимаем кнопку "Войти"
        $("button[type='submit']").click();

        // 4. Проверяем, что попали на страницу успеха (пример условия)
        // Здесь можно проверить:
        // - появление элемента с текстом "Добро пожаловать"
        // - редирект на /dashboard и т.п.
        $("h1").shouldHave(exactText("Добро пожаловать, testuser!"));
    }
}


