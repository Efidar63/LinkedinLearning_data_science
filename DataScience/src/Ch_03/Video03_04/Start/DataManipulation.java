package Ch_03.Video03_04.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataManipulation {
    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> numbers = new ArrayList<>(Arrays.asList(intArray));

        String[] wordsArr = { "hello", "data", "science", "is", "cool" };
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        List<String> longWords = words.stream()
                .filter((word) -> word.length() > 4)
                .collect(Collectors.toList());
        System.out.println(longWords);

        List<Integer> smallNumbers = numbers.stream()
                .filter((x) -> x < 6)
                .collect(Collectors.toList());
        System.out.println(smallNumbers);

        List<String> sortedEmployees = employees.stream()
                .filter((employee) -> employee.jobTitle.equals("developer"))
                .sorted((e1, e2) -> e2.age.compareTo(e1.age))
                .map((employee) -> employee.name)
                .collect(Collectors.toList());
        System.out.println(sortedEmployees);
    }
}
