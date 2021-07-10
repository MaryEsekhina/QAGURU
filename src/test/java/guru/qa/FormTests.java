package guru.qa;



//import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

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
    void nameFillTest() {
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
        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click(); //увлечения
        $("#uploadPicture").uploadFile(new File("src/test/java/../resources/wat.jpeg")); //фото
        $("#currentAddress").setValue("г. Рязань"); //адрес
        //выбираем штат
        $("#state").click();
        $(byText("Haryana")).scrollTo().click();
        $("#city").click();
        $(byText("Karnal")).scrollTo().click();
        $("#submit").click();

        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Mary Esekhina"), text("es@mail.ru"),
                text("9101234567"), text("19 July,1990"), text("English"),
                text("wat.jpeg"), text("г. Рязань"), text("Haryana Karnal"));


    }
}
