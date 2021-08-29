import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WebTests {

    private static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {

        Configuration.baseUrl = config.baseURL();
        Configuration.startMaximized = true;
        if (System.getProperty("type").equals("remote")) {Configuration.remote = config.remoteURL();}

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
        $("button.btn-link.f6").scrollTo().click();
        //кликнуть по SoftAssertion
        $(byText("SoftAssertions")).click();
        //Проверить, что есть пример кода для JUnit5 (наличие слов Using JUnit5)
        $("div.markdown-body").shouldHave(text("Using JUnit5"));
    }

    @Test
    void checkProperty() {

        assertThat(config.browser()).isEqualTo("chrome");
        assertThat(config.browserVersion()).isEqualTo("91");



    }
}
