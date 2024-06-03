package Ch_08.Video08_03.End;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NaiveBayesClassifier {
    private List<DataItem> dataItems;

    public NaiveBayesClassifier() {
        this.dataItems = new ArrayList<>();
    }

    public void addDataItem(DataItem di) {
        this.dataItems.add(di);
    }

    public Map<String, Double> classifyPoint(DataItem unlabelledPoint) {
        List<String> allLabels = new ArrayList<>(
                this.dataItems.stream()
                        .map((point) -> point.getClassifier())
                        .collect(Collectors.toSet())
        );

        Map<String, Double> probabilities = new HashMap<>();

        for (String label : allLabels) {
            List<DataItem> groupDataItems = this.dataItems.stream()
                    .filter((point) -> point.getClassifier().equals(label))
                    .collect(Collectors.toList());

            // These lines are commented out because they won't work yet
//            List<Double> groupColumnMeans = getColumnMeans(groupDataItems);
//            List<Double> groupColumnStdDevs = getColumnStdDevs(groupDataItems);

//            probabilities.put(
//                    label,
//                    getLabelProbabilityForPoint(groupColumnMeans, groupColumnStdDevs, unlabelledPoint)
//            );
        }

        return probabilities;
    }
}
