package Ch_05.Video05_03.Start;

import java.util.List;
import java.util.stream.Collectors;

public class TextLoading {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("adult-sample.data");
        List<PersonRecord> people = lines.stream()
                .map((line) -> PersonRecordUtil.parsePerson(line))
                .collect(Collectors.toList());
        people.forEach((person) -> System.out.println(person));
    }
}
