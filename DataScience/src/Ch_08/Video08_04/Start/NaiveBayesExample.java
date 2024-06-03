package Ch_08.Video08_04.Start;

import java.util.List;
import java.util.stream.Collectors;

public class NaiveBayesExample {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("iris.data");
        List<FlowerRecord> flowers = lines.stream()
                .map((line) -> FlowerRecordUtil.parseFlower(line))
                .collect(Collectors.toList());

        NaiveBayesClassifier classifier = new NaiveBayesClassifier();

        flowers.forEach((flower) -> classifier.addDataItem(flower));

        System.out.println(
                classifier.classifyPoint(new FlowerRecord(6.8,2.8,4.8,1.4, "?")));
    }
}
