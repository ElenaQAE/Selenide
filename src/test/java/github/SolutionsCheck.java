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

/* Ответы на вопросы:
1. Если разобрать на примере d-lg-flex: при поиске по локатору d-lg-flex находится 9 элементов, а при поиске ul.d-lg-flex находится только 1 элемент. То есть указывая ul.класс, мы сначала ищем первый ul, а уже потом в нем ищем класс
2. Исходя из 1 пункта - по локатору ul.d-lg-flex находит 1 элемент, это шапка с разделами Product, Solutions и тд. Selenide находит этот элемент и кликает в середину этого элемента, тем самым попадая на Solutions
3. Лучше всего использовать уникальные локаторы, которые вряд ли будут меняться в дальнейшем. Поиск по тексту - нормальная практика, допустим вот так:
$(".Header-old").$(byText("Solutions")).hover();
Мы ищем нужный нам элемент по тексту в конкретном блоке, а не по всей странице
 */