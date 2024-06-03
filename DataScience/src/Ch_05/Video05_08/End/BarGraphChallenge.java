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

        // Show a bar chart of the average mpg of cars, based on their "origin" (1=america, 2=europe, 3=asia)
        List<CarRecord> americanCars = cars.stream()
                .filter((car) -> car.origin == 1)
                .collect(Collectors.toList());
        List<CarRecord> europeanCars = cars.stream()
                .filter((car) -> car.origin == 2)
                .collect(Collectors.toList());
        List<CarRecord> asianCars = cars.stream()
                .filter((car) -> car.origin == 3)
                .collect(Collectors.toList());

        Series series = new Series();
        series.getData().add(new Data("American", CarRecordUtil.getAverageMpg(americanCars)));
        series.getData().add(new Data("European", CarRecordUtil.getAverageMpg(europeanCars)));
        series.getData().add(new Data("Asian", CarRecordUtil.getAverageMpg(asianCars)));

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Origin");
        yAxis.setLabel("Average mpg");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setAnimated(false);
        barChart.getData().add(series);
        barChart.setTitle("Average mpg of different car origins");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(barChart, 700, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
