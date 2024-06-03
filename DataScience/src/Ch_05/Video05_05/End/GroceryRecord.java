package Ch_05.Video05_05.End;

import java.util.Date;

public class GroceryRecord {
    public final String memberNumber;
    public final Date date;
    public final String itemDescription;

    public GroceryRecord(String memberNumber, Date date, String itemDescription) {
        this.memberNumber = memberNumber;
        this.date = date;
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        return "GroceryRecord{" +
                "memberNumber='" + memberNumber + '\'' +
                ", date=" + date +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
