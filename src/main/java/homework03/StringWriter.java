package homework03;

import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
    public StringWriter(StringParser parsedString) {
        try (FileWriter fileWriter = new FileWriter(parsedString.getSurname() + ".txt", true)) {
            fileWriter.write(parsedString.getSurname() + " " +
                                 parsedString.getName() + " " +
                                 parsedString.getPatronymic() + " " +
                                 parsedString.getBirthday() + " " +
                                 parsedString.getPhoneNumber() + " " +
                                 parsedString.getSex() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
