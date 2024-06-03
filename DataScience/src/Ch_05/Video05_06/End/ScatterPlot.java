package Ch_05.Video05_06.End;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class ScatterPlot extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        List<CarRecord> olderCars = cars.stream()
                .filter((car) -> car.year <= 76)
                .collect(Collectors.toList());

        List<CarRecord> newerCars = cars.stream()
                .filter((car) -> car.year > 76)
                .collect(Collectors.toList());

        Series olderCarSeries = new Series();
        olderCars.forEach((car) -> {
            olderCarSeries.getData().add(new Data(car.weight, car.mpg));
        });

        Series newerCarSeries = new Series();
        newerCars.forEach((car) -> {
            newerCarSeries.getData().add(new Data(car.weight, car.mpg));
        });

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight");
        yAxis.setLabel("MPG");

        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);

        scatterChart.getData().add(olderCarSeries);
        scatterChart.getData().add(newerCarSeries);
        scatterChart.setTitle("Weight vs. Mileage");
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);
        scatterChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(scatterChart, 900, 1000);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
