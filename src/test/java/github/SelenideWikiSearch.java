package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiSearch {
 @Test
 void shouldFindJUnit5Text(){
     // Открыть страницу selenide/selenide
     open("https://github.com/selenide/selenide");
     // Перейти в раздел Wiki
     $("#wiki-tab").click();
     // Ввод значения "SoftAssertions" в поле Pages
     $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
     // Проверка, что в результате поиска отображается "SoftAssertions"
     $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
     // Переход на страницу SoftAssertions
     $("#wiki-pages-box").$(byText("SoftAssertions")).click();
     // Проверка текста JUnit5
     $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
 }
}
