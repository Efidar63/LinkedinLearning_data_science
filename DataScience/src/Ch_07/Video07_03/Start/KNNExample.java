package Ch_07.Video07_03.Start;

import java.util.List;
import java.util.stream.Collectors;

public class KNNExample {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("iris.data");
        List<FlowerRecord> flowers = lines.stream()
                .map((line) -> FlowerRecordUtil.parseFlower(line))
                .collect(Collectors.toList());
    }
}
