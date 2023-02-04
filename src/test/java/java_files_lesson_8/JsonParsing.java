package java_files_lesson_8;

import com.fasterxml.jackson.databind.ObjectMapper;
import java_files_lesson_8.model.Doggo;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParsing {

    ClassLoader cl = JsonParsing.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonParsingTest() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("doggo.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            Doggo jsonDoggo = objectMapper.readValue(reader, Doggo.class);
            assertThat(jsonDoggo.name).contains("Nova");
            assertThat(jsonDoggo.breed).contains("Shiba Inu");
            assertThat(jsonDoggo.color).contains("Orange");
            assertThat(jsonDoggo.age).isEqualTo(2.5);
            assertThat(jsonDoggo.friends).contains("Rex");
        }
    }
}