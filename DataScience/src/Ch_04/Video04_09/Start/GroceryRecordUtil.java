package Ch_04.Video04_09.Start;

import org.apache.commons.csv.CSVRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GroceryRecordUtil {
    public static GroceryRecord parseGroceryRecord(CSVRecord record) {
        try {
            String memberNumber = record.get("Member_number");
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(record.get("Date"));
            String itemDescription = record.get("itemDescription");

            return new GroceryRecord(memberNumber, date, itemDescription);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static Map<String, List<GroceryRecord>> groupGroceryRecordsByMemberNumber(List<GroceryRecord> groceries) {
        return null;
    }
}
