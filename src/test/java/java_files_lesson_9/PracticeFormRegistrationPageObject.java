package java_files_lesson_9;

import org.junit.jupiter.api.Test;

public class PracticeFormRegistrationPageObject extends TestBase {

    TestData testData = new TestData();

    @Test
    void studentRegistrationFormTest() {


        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setUserPhoneNumber(testData.telNumber)
                .setBirthDate(
                        testData.dayMonthYear[0],
                        testData.dayMonthYear[1],
                        testData.dayMonthYear[2])
                .setSubject(testData.subject)
                .setHobbie(testData.hobbies)
                .uploadFile(testData.picture)
                .setAddress(testData.address)
                .selectState(testData.state)
                .selectCity(testData.city);

        registrationPage.clickSubmitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.email)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.telNumber)
                .verifyResult("Date of Birth", testData.dateOfBirth)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobbies)
                .verifyResult("Picture", testData.picture)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city);
    }
}