package tests;

import com.github.javafaker.Faker;
import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FormTest {
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




    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;

    }

    @Test
    void nameFillTest() {

        registrationPage.openPage(); //перешли по ссылке
        registrationPage.enterFirstName(name)
                .enterLastName(surname)
                .enterEmail(email)
                .enterPhoneNumber(phone)
                .chooseGender(gender)
                .setBirthDate("19", "July", "1990")
                .chooseSubj(subj)
                .chooseHobby(hobby)
                .loadPic(picPath)
                .enterAddress(address)
                .chooseState(state)
                .chooseCity(city)
                .submit();

        //проверка
        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(name + " " + surname);
        registrationPage.checkResultsValue(email);
        registrationPage.checkResultsValue(phone);
        registrationPage.checkResultsValue("19 July,1990");
        registrationPage.checkResultsValue(subj);
        registrationPage.checkResultsValue("wat.jpeg");
        registrationPage.checkResultsValue(address);
        registrationPage.checkResultsValue(state + " " + city);
    }
}
