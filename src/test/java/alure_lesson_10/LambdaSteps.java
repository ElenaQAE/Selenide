package alure_lesson_10;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LambdaSteps extends TestBase {


    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Elena QAE")
    @DisplayName("Тест для примера запуска Allure c Lambda")
    public void issueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу репозитория " + repoLink, () -> {
            open(repoLink);
        });

        step("Выбрать вкладку Issues", () -> {
            issueTab.click();
        });

        step("Проверка, что имя ошибки " + name, () -> {
            issueName.should(Condition.exist);
        });
    }
}