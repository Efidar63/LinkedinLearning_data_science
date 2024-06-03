package Ch_05.Video05_08.Start;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class BarGraphChallenge extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());
    }
}
