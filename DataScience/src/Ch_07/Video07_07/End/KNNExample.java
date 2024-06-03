package Ch_07.Video07_07.End;

import java.util.List;
import java.util.stream.Collectors;

public class KNNExample {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("iris.data");
        List<FlowerRecord> flowers = lines.stream()
                .map((line) -> FlowerRecordUtil.parseFlower(line))
                .collect(Collectors.toList());

        KNNClassifier classifier = new KNNClassifier();

        flowers.forEach((flower) -> classifier.addDataItem(flower));

        System.out.println(
                classifier.classifyPoint(new FlowerRecord(0.0, 0.0, 2.5, 0.75, "?"), 30));
    }
}
