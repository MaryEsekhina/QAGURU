package guru.qa.dz3;

import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WikiTest {
    @BeforeAll
    static void setup() {
        baseUrl="https://github.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void checkWikiTest() {
        // открыть страницу github
        open(baseUrl);
        // ввести в поиск selenide
        $("[name=q]").setValue("selenide").pressEnter();
        //открыть страницу selenide/selenide
        $("ul.repo-list li a").click();
        // кликнуть по кнопке Wiki
        $("main li.d-flex a[href=\"/selenide/selenide/wiki\"]").click();
        //развернуть весь список страниц Pages
        $("button.btn-link.f6").click();
        //кликнуть по SoftAssertion
        $(byText("SoftAssertions")).click();
        //Проверить, что есть пример кода для JUnit5 (наличие слов Using JUnit5)
        $("div.markdown-body").shouldHave(text("Using JUnit5"));
    }
}
