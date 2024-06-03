package Ch_07.Video07_05.Start;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KNNClassifier {
    List<DataItem> dataItems;

    public KNNClassifier() {
        this.dataItems = new ArrayList<>();
    }

    public void addDataItem(DataItem di) {
        this.dataItems.add(di);
    }

    public Map<String, Integer> classifyPoint(DataItem unlabelledPoint, Integer numberOfNeighbors) {
        List<Double> pointDistances = this.dataItems.stream()
                .map((point) -> DataItemUtil.getDistance(point, unlabelledPoint))
                .sorted((d1, d2) -> d1.compareTo(d2))
                .collect(Collectors.toList());
        System.out.println(pointDistances);

        return null;
    }
}
