package Ch_04.Video04_06.End;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRecordUtil {
    public static CarRecord parseCar(String dataString) {
        List<String> fields = new ArrayList<>(Arrays.asList(dataString.split("\\s+")));
        try {
            Float mpg = Float.parseFloat(fields.get(0).trim());
            Integer numberOfCylinders = Integer.parseInt(fields.get(1).trim());
            Float displacement = Float.parseFloat(fields.get(2).trim());
            Float weight = Float.parseFloat(fields.get(4).trim());
            Integer year = Integer.parseInt(fields.get(6).trim());
            Integer origin = Integer.parseInt(fields.get(7).trim());

            return new CarRecord(mpg, numberOfCylinders, displacement, weight, year, origin);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static Float getAverageMpg(List<CarRecord> cars) {
        Float sum = 0f;
        for (CarRecord car : cars) {
            sum += car.mpg;
        }
        return sum / cars.size();
    }
}
