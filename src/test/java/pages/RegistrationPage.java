package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private String TITLE_TEXT = "Student Registration form";

    private SelenideElement
            FirstNameInput = $("#firstName"),
            LastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            Gender = $("#genterWrapper"),
            UserPhoneNumber = $("#userNumber"),
            DateOfBirthInput = $("#dateOfBirthInput"),
            SubjectInput = $("#subjectsInput"),
            HobbiesChoose = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            setAddressInput = $("#currentAddress"),
            selectStatePopUp = $("#state"),
            selectState = $("#stateCity-wrapper"),
            selectCityPopUp = $("#city"),
            selectCity = $("#city"),
            SubmitButton = $("#submit");


    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String text) {
        FirstNameInput.setValue(text);
        return this;
    }

    public RegistrationPage setLastName(String text) {
        LastNameInput.setValue(text);
        return this;
    }

    public RegistrationPage setUserEmail(String text) {
        userEmail.setValue(text);
        return this;
    }

    public RegistrationPage setGender(String text) {
        Gender.$(byText(text)).click();
        return this;
    }

    public RegistrationPage setUserPhoneNumber(String text) {
        UserPhoneNumber.setValue(text);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        DateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubject(String text) {
        SubjectInput.setValue(text).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String text) {
        HobbiesChoose.$(byText(text)).click();
        return this;
    }

    public RegistrationPage uploadFile(String text) {
        uploadPictureButton.uploadFromClasspath(text);
        return this;
    }

    public RegistrationPage setAddress(String text) {
        setAddressInput.setValue(text);
        return this;
    }

    public RegistrationPage selectState(String text) {
        selectStatePopUp.click();
        selectState.$(byText(text)).click();
        return this;
    }

    public RegistrationPage selectCity(String text) {
        selectCityPopUp.click();
        selectCity.$(byText(text)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        SubmitButton.click();
        return this;
    }
}