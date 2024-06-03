package Ch_02.Video02_02.Start;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class DataFormatting {
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
    }
}
