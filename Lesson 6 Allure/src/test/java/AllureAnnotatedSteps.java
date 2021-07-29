import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static io.qameta.allure.Allure.step;

public class AllureAnnotatedSteps {


    @Step("Открываем github.com")
    public void openPage() {
        open("https://github.com");}

    @Step("Ищем репозиторий")
    public void searchReposytory(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();}

    @Step("Открываем репозиторий")
    public void goToReposytory(String repo){
        $(linkText(repo)).click();}

    @Step("Кликаем Issues")
    public void goToIssues(){
        $(partialLinkText("Issues")).click();}

    @Step("Проверяем, что у Issue #68 заголовок Listeners NamedBy")
    public void checkIssue(String name){
        $("#issue_68_link").shouldHave(text(name));
    }
}
