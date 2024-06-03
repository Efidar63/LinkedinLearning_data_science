package Ch_07.Video07_06.End;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerRecordUtil {
    public static FlowerRecord parseFlower(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split(",")));

        try {
            Double sepalLength = Double.parseDouble(fields.get(0).trim());
            Double sepalWidth = Double.parseDouble(fields.get(1).trim());
            Double petalLength = Double.parseDouble(fields.get(2).trim());
            Double petalWidth = Double.parseDouble(fields.get(3).trim());
            String species = fields.get(4).trim();

            return new FlowerRecord(sepalLength, sepalWidth, petalLength, petalWidth, species);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
