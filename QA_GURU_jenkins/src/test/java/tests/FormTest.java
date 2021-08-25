package tests;


import com.github.javafaker.Faker;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;



public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String surname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String gender = faker.demographic().sex();
    String subj = "English";
    String hobby = "Reading";
    String picPath = "src/test/java/../resources/wat.jpeg";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Karnal";



    @Test
     void nameFillTest(){

        step("Открываем github.com", () -> registrationPage.openPage()); //перешли по ссылке
        step("Вводим основную информацию", () -> registrationPage.enterFirstName(name)
                .enterLastName(surname)
                .enterEmail(email)
                .enterPhoneNumber(phone)
                .chooseGender(gender)
                .setBirthDate("19", "July", "1990"));
        step("Выбираем предмет и хобби", () -> registrationPage.chooseSubj(subj)
                .chooseHobby(hobby));
        step("Загружаем картинку", () -> registrationPage.loadPic(picPath));
        step("Вводим адрес", () -> registrationPage.enterAddress(address)
                .chooseState(state)
                .chooseCity(city));
        step("Нажимаем Submit", () -> registrationPage.submit());

        //проверка
        step("Нажимаем Submit", () -> {registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(name + " " + surname);
        registrationPage.checkResultsValue(email);
        registrationPage.checkResultsValue(phone);
        registrationPage.checkResultsValue("19 July,1990");
        registrationPage.checkResultsValue(subj);
        registrationPage.checkResultsValue("wat.jpeg");
        registrationPage.checkResultsValue(address);
        registrationPage.checkResultsValue(state + " " + city);});
    }
}
