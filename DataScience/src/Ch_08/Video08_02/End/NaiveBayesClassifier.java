package Ch_08.Video08_02.End;

import java.util.ArrayList;
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
        System.out.println(allLabels);

        return null;
    }
}
