package Ch_04.Video04_03.End;

import java.util.List;

public class TextLoading {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("adult-sample.data");
        System.out.println(lines);
    }
}
