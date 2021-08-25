package pages;

import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class RegistrationPage {
    private Calendar calendar = new Calendar();
    private static String RESULTS_TITLE = "Thanks for submitting the form";

    public void openPage() {
        open("/automation-practice-form");
    }

    public RegistrationPage enterFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public RegistrationPage enterLastName(String surname) {
        $("#lastName").setValue(surname);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage chooseGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationPage enterPhoneNumber(String phNumber) {
        $("#userNumber").setValue(phNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage chooseSubj(String subj) {
        $("#subjectsInput").setValue(subj).pressEnter();
        return this;
    }

    public RegistrationPage chooseHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage loadPic(String picPath) {
        $("#uploadPicture").uploadFile(new File(picPath));
        return this;
    }

    public RegistrationPage enterAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage chooseState(String state) {
        $("#state").click();
        $(byText(state)).scrollTo().click();
        return this;
    }

    public RegistrationPage chooseCity(String city) {
        $("#city").click();
        $(byText(city)).scrollTo().click();
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public void checkResultsTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue(String value) {
        $(".table-responsive").shouldHave(text(value));
    }
}

