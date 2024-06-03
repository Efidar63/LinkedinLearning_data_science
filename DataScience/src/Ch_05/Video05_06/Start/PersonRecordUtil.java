package Ch_05.Video05_06.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRecordUtil {
    public static PersonRecord parsePerson(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split(",")));

        try {
            Integer age = Integer.parseInt(fields.get(0));
            String employmentStatus = fields.get(1).trim();
            String education = fields.get(3).trim();

            return new PersonRecord(age, employmentStatus, education);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
