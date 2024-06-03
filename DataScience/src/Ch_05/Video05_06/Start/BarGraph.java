package Ch_05.Video05_06.Start;

import javafx.application.Application;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class BarGraph extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        List<CarRecord> fourCylinderCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 4)
                .collect(Collectors.toList());
        List<CarRecord> sixCylinderCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 6)
                .collect(Collectors.toList());
        List<CarRecord> eightCylinderCars = cars.stream()
                .filter((car) -> car.numberOfCylinders == 8)
                .collect(Collectors.toList());

        Series series = new Series();
        series.getData().add(new Data("4", CarRecordUtil.getAverageMpg(fourCylinderCars)));
        series.getData().add(new Data("6", CarRecordUtil.getAverageMpg(sixCylinderCars)));
        series.getData().add(new Data("8", CarRecordUtil.getAverageMpg(eightCylinderCars)));
    }
}
