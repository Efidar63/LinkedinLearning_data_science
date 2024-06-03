package Ch_04.Video04_07.Start;

public class PersonRecord {
    public final Integer age;
    public final String employmentStatus;
    public final String education;

    public PersonRecord(Integer age, String employmentStatus, String education) {
        this.age = age;
        this.employmentStatus = employmentStatus;
        this.education = education;
    }

    @Override
    public String toString() {
        return "PersonRecord{" +
                "age=" + age +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
