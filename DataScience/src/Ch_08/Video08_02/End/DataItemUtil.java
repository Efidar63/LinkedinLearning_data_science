package Ch_08.Video08_02.End;

import java.util.List;

public class DataItemUtil {
    public static Double getDistance(DataItem item1, DataItem item2) {
        List<Double> item1Coordinates = item1.getCoordinates();
        List<Double> item2Coordinates = item2.getCoordinates();

        Double sum = 0.0;
        for (int i = 0; i < item1Coordinates.size(); i++) {
            Double dimensionDistance = item2Coordinates.get(i) - item1Coordinates.get(i);
            sum += dimensionDistance * dimensionDistance;
        }
        return Math.sqrt(sum);
    }
}
