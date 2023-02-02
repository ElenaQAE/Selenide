package java_junit_lesson_7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ValueSourceSearchTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "холодильник",
            "ipad"
    })

    @ParameterizedTest(name = "Поиск осуществлен по значению {0}")
    void holodilnikSearchTest(String productName) {
        open("https://www.holodilnik.ru/");
        $("#top_search").setValue(productName).pressEnter();
        $$(".product-specification").first().shouldHave(text(productName));
    }
}