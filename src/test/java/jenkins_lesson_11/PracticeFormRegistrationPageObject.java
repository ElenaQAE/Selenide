package jenkins_lesson_11;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormRegistrationPageObject extends TestBase {

    TestData testData = new TestData();

    @Tag("run_on_jenkins")
    @Test
    void studentRegistrationFormTest() {

        step("Заполнение полей регистрации", () -> {
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
                });

        step("Нажатие на кнопку подтверждения", () -> {
                    registrationPage.clickSubmitButton();
                });
        step("Проверка результатов заполнения", () -> {
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
        });
    }
}
