package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

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
     $("#wiki-pages-box").$(byText("SoftAssertions")).click(); // нужно ли объединять с предыдущим тестом
//     $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
     $("#wiki-body").$(byText("3. Using JUnit5 extend test class:1"));


//     $("div.markdown-body").shouldHave(text("Using JUnit5 extend test class:"));

 }
}

/*
1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?

        Если может - приведите пример, когда.

        2. Разработайте следующий автотест:
        - Откройте страницу Selenide в Github
        - Перейдите в раздел Wiki проекта
        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
*/