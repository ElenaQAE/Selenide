package alure_lesson_10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    String
            repoLink = "/eroshenkoam/allure-example/",
            name = "issue_to_test_allure_report";

    SelenideElement
            issueTab = $("#issues-tab"),
            issueName = $(withText(name));

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }
}