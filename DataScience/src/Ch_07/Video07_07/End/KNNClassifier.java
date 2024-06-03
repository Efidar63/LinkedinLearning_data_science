package Ch_07.Video07_07.End;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
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

    private Map<String, Integer> countOccurrences(List<String> list) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String str : list) {
            Integer currentCount = occurrences.get(str);
            occurrences.put(str, (currentCount == null) ? 1 : currentCount + 1);
        }
        return occurrences;
    }

    public Map<String, Integer> classifyPoint(DataItem unlabelledPoint, Integer numberOfNeighbors) {
        List<Pair<String, Double>> pointDistances = this.dataItems.stream()
                .map((point) -> new Pair<String, Double>(point.getClassifier(), DataItemUtil.getDistance(point, unlabelledPoint)))
                .sorted((d1, d2) -> d1.getValue().compareTo(d2.getValue()))
                .collect(Collectors.toList());

        List<String> closestLabels = pointDistances
                .subList(0, Math.min(pointDistances.size(), numberOfNeighbors))
                .stream()
                .map((pair) -> pair.getKey())
                .collect(Collectors.toList());

        return countOccurrences(closestLabels);
    }
}
