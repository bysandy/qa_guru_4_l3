package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @Test
    void shouldFindSoftAssertion() {
        // открыть страничку github.com
        open("https://github.com");
        // ввести selenide в строку поиска и
        // нажать ENTER
        $("[name='q']").setValue("selenide").pressEnter();
        // выбрать первый найденный проект
        $(".repo-list a").click();
        // тапнуть по Wiki
        $(byText("Wiki")).click();
        // проверяем что есть Soft Assertions
        $("#wiki-content").shouldHave(text("Soft assertions"));
        // тапнуть по Soft assertions
        $(byText("Soft assertions")).click();
        // проверяем что есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }


}
