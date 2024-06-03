package Ch_08.Video08_05.End;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.StatUtils;

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

    private List<Double> getColumnMeans(List<DataItem> items) {
        List<Double> columnMeans = new ArrayList<>();
        for (int i = 0; i < items.get(0).getCoordinates().size(); i++) {
            int finalI = i;
            Double columnMean = StatUtils.mean(
                    items.stream()
                        .map((item) -> item.getCoordinates().get(finalI))
                        .mapToDouble(Double::doubleValue)
                        .toArray()
            );
            columnMeans.add(columnMean);
        }
        return columnMeans;
    }

    private List<Double> getColumnStdDevs(List<DataItem> items) {
        List<Double> columnStdDevs = new ArrayList<>();
        for (int i = 0; i < items.get(0).getCoordinates().size(); i++) {
            int finalI = i;
            Double columnStdDev = StatUtils.variance(
                    items.stream()
                            .map((item) -> item.getCoordinates().get(finalI))
                            .mapToDouble(Double::doubleValue)
                            .toArray()
            );
            columnStdDevs.add(Math.sqrt(columnStdDev));
        }
        return columnStdDevs;
    }

    private Double getLabelProbabilityForPoint(List<Double> groupColumnMeans, List<Double> groupColumnStdDevs, DataItem item) {
        Double probability = 1.0;
        for (int i = 0; i < groupColumnMeans.size(); i++) {
            Double mean = groupColumnMeans.get(i);
            Double stdDev = groupColumnStdDevs.get(i);
            Double itemValue = item.getCoordinates().get(i);
            NormalDistribution dist = new NormalDistribution(mean, stdDev);
            probability *= dist.cumulativeProbability(itemValue);
        }
        return probability;
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

            List<Double> groupColumnMeans = getColumnMeans(groupDataItems);
            List<Double> groupColumnStdDevs = getColumnStdDevs(groupDataItems);

            probabilities.put(
                    label,
                    getLabelProbabilityForPoint(groupColumnMeans, groupColumnStdDevs, unlabelledPoint)
            );
        }

        return probabilities;
    }
}
