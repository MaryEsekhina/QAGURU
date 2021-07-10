package guru.qa;



import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTests {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void NameFillTest() {
        open("/automation-practice-form"); //перешли по ссылке
        $("#firstName").setValue("Mary"); //ввели имя
        $("#lastName").setValue("Esekhina"); //ввели фамилию
        $("#userEmail").setValue("es@mail.ru"); //ввели почту
        $("#genterWrapper").$(byText("Female")).click(); //выбрали пол

        $("#userNumber").setValue("9101234567");//номер телефона
        //выбираем дату рождения
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--019").click();
        //выбираем предмет
        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click(); //увлечения
        $("#uploadPicture").setValue("K:\\wat.jpeg"); //фото
        $("#currentAddress").setValue("г. Рязань"); //адрес
        //выбираем штат
        $("#state").click();
        $(byText("Haryana")).scrollTo().click();
        $("#city").click();
        $(byText("Karnal")).scrollTo().click();
        $("#submit").click();

        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("Mary Esekhina"), Condition.text("es@mail.ru"),
                Condition.text("9101234567"), Condition.text("19 July,1990"),Condition.text("English"),
                Condition.text("wat.jpeg"),Condition.text("г. Рязань"),Condition.text("Haryana Karnal"));


    }
}
