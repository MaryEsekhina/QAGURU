
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureLambdaTest {
    private String REPOSITORY = "eroshenkoam/allure-example";
    private String ISSUE_NAME = "Listeners NamedBy";
    @Test
    public void testRepositoryIssueLambda() {
        step("Открываем github.com", ()-> open("https://github.com"));

        step ("Ищем репозиторий", ()-> {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();});

        step("Открываем репозиторий", ()-> $(linkText(REPOSITORY)).click());
        step("Кликаем Issues", ()-> $(partialLinkText("Issues")).click());
        step("Проверяем, что у Issue #68 заголовок Listeners NamedBy", ()->{
        $("#issue_68_link").shouldHave(text(ISSUE_NAME));});
    }
}
