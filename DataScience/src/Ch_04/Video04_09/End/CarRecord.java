package Ch_04.Video04_09.End;

public class CarRecord {
    public final Float mpg;
    public final Integer numberOfCylinders;
    public final Float displacement;
    public final Float weight;
    public final Integer year;
    public final Integer origin;

    public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight, Integer year, Integer origin) {
        this.mpg = mpg;
        this.numberOfCylinders = numberOfCylinders;
        this.displacement = displacement;
        this.weight = weight;
        this.year = year;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "CarRecord{" +
                "mpg=" + mpg +
                ", numberOfCylinders=" + numberOfCylinders +
                ", displacement=" + displacement +
                ", weight=" + weight +
                ", origin=" + origin +
                '}';
    }
}
