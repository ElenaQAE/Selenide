package java_junit_lesson_7;

import com.codeborne.selenide.Configuration;
import java_junit_lesson_7.data.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MethoSourceLocaleTest {
    static Stream<Arguments> miroLocaleData() {
        return Stream.of(
                Arguments.of(Locale.English, List.of(
                        "Product" + " " + "Solutions" + " " + "Resources" + " " + "Enterprise" + " " +
                                "Pricing")),
                Arguments.of(Locale.Nederlands, List.of(
                        "Product" + " " + "Oplossingen" + " " + "Hulpbronnen" + " " + "Enterprise" + " " + "Prijzen"))
        );
    }

    @MethodSource("miroLocaleData")
    @ParameterizedTest(name = "Для языка {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    void miroSiteShouldContainAllOfButtonsForGivenLocale(
            Locale language,
            List<String> buttons
    ) {
        open("https://miro.com/");
        $(".LanguageSwitcher__SwitcherContainer-sc-1n6vypn-0").click();
        $(byText(language.name())).click();
        $$(".fIGZUK").filter(visible).shouldHave(texts(buttons));

    }
}