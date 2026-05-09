package pd20.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pd20.dto.UserReport;

import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonFileWriter {
    public static void save(UserReport report, String file) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("src/pd20/" + file), report);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
