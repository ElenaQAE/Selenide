package alure_lesson_10;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class StepsForStepsAnnotation extends TestBase {

    @Step("Открыть страницу репозитория {repoLink}")
    public void openRepositoryPage() {
        open(repoLink);
    }

    @Step("Выбрать вкладку Issues")
    public void selectIssuesTab() {
        issueTab.click();
    }

    @Step("Проверка, что имя ошибки {name}")
    public void checkIssueName() {
        issueName.should(Condition.exist);
    }
}
