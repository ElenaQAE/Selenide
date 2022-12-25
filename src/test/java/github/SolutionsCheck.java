package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class SolutionsCheck {

 @Test
 void solutionPageCheck() {
  open("https://github.com/");
  // Переход в Solutions
  $$(".d-lg-flex > li").get(1).hover(); // 1.вопрос: при работе со списками, нужно ли уточнять сперва, что это ul.класс или можно просто сразу написать .класс?
  //$$("ul.d-lg-flex").first().click(); // 2. вопрос: почему при first нажимает на (Solutions), а не на (Product)?, он же первый идёт.
  // $(".Header-old").$(byText("Solutions")).click(); // 3. вопрос: насколько хорошей практикой искать по тексту?
  // Переход в Enterprise
  $$(".d-lg-flex > li").get(1).$("a").click();
  // Проверка заголовков на странице
  $$("div>h1").shouldHave(texts("Build like the best", "Build like the best"));
 }

 @Test
 void dragAndDropTriangleonHerokuapp() {
  open("https://the-internet.herokuapp.com/drag_and_drop");
  $(("#column-a")).dragAndDropTo($("#column-b"));
  $("#column-a header").shouldHave(text("B"));
  $("#column-b header").shouldHave(text("A"));
  // попытки выполнить с actions
  // actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
  //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(350,0).release().perform();
  // actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
 }
}
