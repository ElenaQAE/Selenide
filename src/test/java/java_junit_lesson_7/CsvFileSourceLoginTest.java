package java_junit_lesson_7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CsvFileSourceLoginTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @CsvFileSource(resources = "/sd_testdata.csv")
    @ParameterizedTest(name = "Все пользователи могут залогиниться на сайт")
    void loginUsersTestWithCsvFile(String userName, String password) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $(".header_secondary_container .title").shouldHave(text("Products"));
    }
}

