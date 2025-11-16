Основные сниппеты кода
Для работы с браузером
Открытие страницы:
// Абсолютный путь
open("https://google.com");

// Относительный путь
open("/customer/orders");

// Прохождение браузерных окон авторизации
open("/", AuthenticationType.BASIC,
new BasicAuthCredentials("user",
"password"));
Пример страницы авторизации:

Кнопки навигации:
// Кнопка назад
Selenide.back();

// Кнопка обновить страницу
Selenide.refresh();
Очистка данных:
// Очистка файлов куки
Selenide.clearBrowserCookies();

// Очистка Local Storage
Selenide.clearBrowserLocalStorage();
Браузерные всплывающие окна:
// Подтверждение во всплывающих окнах
Selenide.confirm();

// Отмена во всплывающих окнах
Selenide.dismiss();
Управление окнами (вкладками):
// Закрыть активную вкладку
Selenide.closeWindow();

// Закрыть все вкладки (браузер, ожидаемо, тоже закроется)
Selenide.closeWebDriver();
Переключение между фреймами страницы:
// Переход во фрейм по имени или селктору
Selenide.switchTo().frame("new");

// Переход во фрейм по умолчанию
Selenide.switchTo().defaultContent();
Селекторы
Селекторы обозначаются с помощью символа доллара — $. Но в языке Kotlin этот символ зарезервирован для внутреннего
использования, поэтому вместо него следует использовать ключевое слово element.

Поиск элемента по селектору:

$("div").click();

// Если нужен не первый n-ый div, то можно указать его индекс
// Важно помнить, что нумерация начинается с нуля
// В примере найдется третий div
$("div",
2).click();
Поиск по тексту:
// Поиск по полной строке
$(byText("full text")).click();

// Поиск по подстроке
$(withText("ull tex")).click();

// Поиск по тегу и тексту одновременно
// Полная строка
$(byTagAndText("div",
"full text"));

// Подстрока
$(withTagAndText("div",
"ull text"));
Поиск по DOM:
// По родителю
$("").parent();

// Поиск по дочерним элементам (сверху вниз)
$("").sibling(1);

// То же, что и sibling, но снизу вверх
$("").preceding(1);

// Ищет предков элемента снизу вверх
$("").closest("div");

// То же, что и closest
$("").ancestor("div");

// Поиск по псевдоселекторам
$("div:last-child");
Опциональный поиск:
// Поиск по атрибуту
$(byAttribute("abc",
"x")).click();
$("[abc=x]").click();

// Поиск по ID элемента
$(byId("mytext")).click();
$("#mytext").click();

// Поиск по Class Name
$(byClassName("red")).click();
$(".red").click();
Команды
Мышка:
// Клик по элементу
$("").click();

// Двойной клик
$("").doubleClick();

// Клик ПКМ
$("").contextClick();

// Подвести курсор
$("").hover();
Текстовые поля:
// Очистить поле и поместить значение
$("").setValue("text");

// Не очищать поле и поместить значение
$("").append("text");

// Очистить поле
$("").clear();

// Очистить поле путем помещения в поле пустой строки
$("").setValue("");
Клавиши:
// Нажать клавишу на конкретном элементе
$("div").sendKeys("c");

// Нажать клавишу во всем приложении
actions().sendKeys("c").perform();

// Последовательности клавиш
actions().sendKeys(Keys.chord(Keys.CONTROL,
"f")).perform();

// Пример применения клавиши по тегу html (вся страница)
$("html").sendKeys(Keys.chord(Keys.CONTROL,
"f"));

// Нажать Enter
$("").pressEnter();

// Нажать Esc
$("").pressEscape();

// Нажать Tab
$("").pressTab();
Сложные комбинации: Начинаются команды методом actions(), а заканчиваются perform().

// Подвинуть курсор к элементу, кликнуть и держать, передвинуть по X и Y, отпустить кнопку мыши
actions().moveToElement($("div")).clickAndHold().moveByOffset(300,
200).release().perform();
Проверки
$("").shouldBe(visible);
$("").shouldNotBe(visible);
$("").shouldHave(text("abc"));
$("").shouldNotHave(text("abc"));
$("").should(appear);
$("").shouldNot(appear);

// Кастомная настройка таймаута
$("").shouldBe(visible, Duration.ofSeconds(30));
Условия проверок
Методу проверки всегда необходимо передавать условие, которое будет проверяться.

// Видимый/скрытый элемент
$("").shouldBe(visible);
$("").shouldBe(hidden);

// Условия содержания текста
// Поиск по подстроке
$("").shouldHave(text("abc"));

//Поиск полного совпадения
$("").shouldHave(exactText("abc"));

// Поиск с учетом регистра по подстроке
$("").shouldHave(textCaseSensitive("abc"));

// Поиск полного совпадения с учетом регистра
$("").shouldHave(exactTextCaseSensitive("abc"));

// Сложные условия
$("").should(matchText("[0-9]abc$"));

// CSS
// Проверка класса
$("").shouldHave(cssClass("red"));

// Проверка элемента
$("").shouldHave(cssValue("font-size",
"12"));

// Поля ввода
$("").shouldHave(value("25"));
$("").shouldHave(exactValue("25"));
$("").shouldBe(empty);

// Атрибуты
$("").shouldHave(attribute("disabled"));
$("").shouldHave(attribute("name",
"example"));
$("").shouldHave(attributeMatching("name",
"[0-9]abc$"));

// Чекбоксы
$("").shouldBe(checked); // for checkboxes

// Проверка нахождения элемента в DOM, при этом пользователь может его не видеть
$("").should(exist);
Коллекции
Коллекции обозначаются двойным знаком доллара — $$. В Kotlin следует использовать ключевое слово elements.

Пример:

$$("div");
elements("div");
Фильтрации:

$$("div").filterBy(text("123")).shouldHave(size(1));
$$("div").excludeWith(text("123")).shouldHave(size(1));
Навигация:
// Первый
$$("div").first().click();

// Последний
$$("div").last().click();

// По номеру
$$("div").get(1).click();
Проверки коллекций:
// Размер
$$("").shouldHave(size(0));
// То же, что выше
$$("").shouldBe(CollectionCondition.empty);

// Подтекст
$$("").shouldHave(texts("Alfa",
"Beta",
"Gamma"));
// Текст с полным соответствием
$$("").shouldHave(exactTexts("Alfa",
"Beta",
"Gamma"));

// Текст без учета порядка
$$("").shouldHave(textsInAnyOrder("Beta",
"Gamma",
"Alfa"));
$$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta",
"Gamma",
"Alfa"));

// Поиск конкретного элемента по тексту
$$("").shouldHave(itemWithText("Gamma"));

// Проверка размера коллекции
$$("").shouldHave(sizeGreaterThan(0));
$$("").shouldHave(sizeGreaterThanOrEqual(1));
$$("").shouldHave(sizeLessThan(3));
$$("").shouldHave(sizeLessThanOrEqual(2));
JavaScript
// Запуск
executeJavaScript("alert('selenide')");

// Запуск с аргументами
executeJavaScript("alert(arguments[0]+arguments[1])",
"abc",
12);

// Запуск с аргументами и возвращением результата
long fortytwo = executeJavaScript("return arguments[0]*arguments[1];",
6,
7);
Файлы
Стоит помнить про обработку ошибок, иначе могут быт непредвиденные результаты выполнения теста.

// Загрузка, но работает только с <a href="..">
File file1 = $("a.fileLink").download();

// Более простая загрузка по кнопке
File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));

File file = new File("src/test/resources/readme.txt");

// Загрузка файла на сайт
$("#file-upload").uploadFile(file);
$("#file-upload").uploadFromClasspath("readme.txt");

// Файлы обычно на сайт не загружаются сами
// И загрузку надо подтвердить нажатием кнопки
$("uploadButton").click();

