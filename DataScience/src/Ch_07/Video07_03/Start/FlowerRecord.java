package Ch_07.Video07_03.Start;

public class FlowerRecord {
    public final Double sepalLength;
    public final Double sepalWidth;
    public final Double petalLength;
    public final Double petalWidth;
    public final String species;

    public FlowerRecord(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    @Override
    public String toString() {
        return "FlowerRecord{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", species='" + species + '\'' +
                '}';
    }
}
