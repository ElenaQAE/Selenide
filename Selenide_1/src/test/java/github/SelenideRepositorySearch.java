package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {


 @Test
 void shouldFindSelenideRepositoryAtTheTop() {
    //открыть главную страницу
    open("https://github.com");
    $(".header-search-input").setValue("selenide").pressEnter(); // "[data-test-selector=nav-search-input]"
    $$("ul.repo-list li").first().$("a").click();
    $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));

 }
}