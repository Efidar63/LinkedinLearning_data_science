package Ch_02.Video02_02.End;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.List;

public class DataFormatting {
    static class Person {
        public final Integer id;
        public final String name;
        public final Boolean likesPizza;

        public Person(Integer id, String name, Boolean likesPizza) {
            this.id = id;
            this.name = name;
            this.likesPizza = likesPizza;
        }
    }

    static class PersonUtils {
        public static String getFirstName(Person person) {
            return person.name.split(" ")[0];
        }
    }

    public static void main(String[] args) {
        // Univariate arrays
        String[] names = { "John Doe", "Jane Jones", "Bill Smith", "Betsy Garcia" };
        Integer[] ids = { 123, 234, 345, 456 };
        Boolean[] likesPizza = { false, true, true, false };

        // Multivariate arrays
        Integer[] person1 = { 123, 0, 1994, 4, 3 };
        Integer[] person2 = { 234, 1, 1940, 8, 4 };

        // Matrices
        double[][] peopleData = {
                { 123, 0, 1994, 4, 3 },
                { 234, 1, 1940, 8, 4 },
        };

        RealMatrix matrix = new Array2DRowRealMatrix(peopleData);

        // Data Objects
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person(123, "John Doe", false));
        peopleList.add(new Person(234, "Jane Jones", true));
    }
}
