package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class SoftAssertionsTest {
    @Test
    void shouldFindSoftAssertion() {
        // открыть страничку github.com
        Selenide.open("https://github.com");
        // ввести selenide в строку поиска и
        // нажать ENTER
        Selenide.$("[name='q']").setValue("selenide").pressEnter();
        // выбрать первый найденный проект
        Selenide.$$("ul.repo-list li").first().$("a").click();
        // тапнуть по Wiki
        Selenide.$$("ul.UnderlineNav-body li").get(4).$("a").click();
        // проверяем что есть Soft Assertions
        Selenide.$("#wiki-content").shouldHave(text("Soft assertions"));
        // тапнуть по Soft assertions
        Selenide.$(byText("Soft assertions")).click();
        // проверяем что есть пример кода для JUnit5
        Selenide.$(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }


}
