package qa.demo;

import org.junit.jupiter.api.Test;

import java.io.File;

public class PracticeFormRegistrationPageObject extends TestBase {
    @Test
    void practiceFormRegistration() {
        // Переменные
        String
                name = "Random",
                lastName = "Name",
                email = "email@email.com",
                phoneNumber = "1234567890",
                currentAddress = "Address 1",
                gender = "Other",
                dateOfBirth = "1 January,2000",
                subject = "Maths",
                hobbies = "Sports",
                nameFile = "/shiba.png",
                state = "NCR",
                city = "Delhi";

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserPhoneNumber(phoneNumber)
                .setBirthDate("01", "January", "2000")
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadFile(nameFile)
                .setAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmitButton();

        registrationPage.verifyResultsModalAppears();
        registrationPage
                .verifyResult("Student Name", name + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Address", currentAddress)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", nameFile)
                .verifyResult("State", state)
                .verifyResult("City", city);
    }
}
