package guru.qa.dz3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

class DragAndDropTest {
    @BeforeAll
    static void setup() {
        baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.startMaximized = true;
    }

    @Test
    void drAndDrtest() {
        open(baseUrl);
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(Condition.text("A"));


    }
}