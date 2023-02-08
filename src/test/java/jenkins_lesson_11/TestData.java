package jenkins_lesson_11;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker();

    String firstName = faker.gameOfThrones().character();
    String lastName = faker.gameOfThrones().house();
    String email = faker.internet().emailAddress();
    String gender = getRandomValue
            ("Male",
                    "Female",
                    "Other");
    String telNumber = String.valueOf(faker.number().numberBetween(9001111111L, 9999999999L));
    String[] dayMonthYear = getRandomDate();
    String dateOfBirth = String.format("%s %s,%s", dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
    String subject = getRandomValue
            ("Math",
                    "Chemistry",
                    "Physics",
                    "Computer Science",
                    "English",
                    "History");
    String hobbies = getRandomValue
            ("Sports",
                    "Reading",
                    "Music");
    String picture = "shiba.png";
    String address = faker.address().city();
    String state = getRandomValue
            ("NCR",
                    "Uttar Pradesh",
                    "Haryana",
                    "Rajasthan");
    String city = getCity();

    private String getRandomValue(String... initialValues) {
        return faker.options().option(initialValues);
    }

    private String[] getRandomDate() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).
                format(faker.date().birthday(16, 45)).split(" ");
    }

    private String getCity() {
        String cityName = null;

        if (state.equals("NCR")) {
            cityName = getRandomValue("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            cityName = getRandomValue("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            cityName = getRandomValue("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            cityName = getRandomValue("Jaipur", "Jaiselmer");
        }

        return cityName;
    }
}