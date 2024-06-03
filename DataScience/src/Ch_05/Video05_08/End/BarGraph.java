package Ch_05.Video05_08.End;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
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

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of cylinders");
        yAxis.setLabel("Average mpg");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setAnimated(false);
        barChart.getData().add(series);
        barChart.setTitle("Average mpg of different engine types");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(barChart, 700, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
