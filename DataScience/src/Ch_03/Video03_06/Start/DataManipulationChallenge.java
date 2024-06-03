package Ch_03.Video03_06.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManipulationChallenge {
    public static void main(String[] args) {
        DataManipulation.Employee[] employeesArr = {
                new DataManipulation.Employee("John", 34, "developer", 80000f),
                new DataManipulation.Employee("Hannah", 24, "developer", 95000f),
                new DataManipulation.Employee("Bart", 50, "sales executive", 100000f),
                new DataManipulation.Employee("Sophie", 49, "construction worker", 40000f),
                new DataManipulation.Employee("Darren", 38, "writer", 50000f),
                new DataManipulation.Employee("Nancy", 29, "developer", 75000f),
        };
        List<DataManipulation.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // Use map/filter/collect/sort to get a list of all the employees names who are over 30, sorted by salary
    }
}
