package Ch_04.Video04_07.End;

import java.util.List;
import java.util.stream.Collectors;

public class TextLoadingTabs {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());
        cars.forEach((car) -> System.out.println(car));
    }
}
