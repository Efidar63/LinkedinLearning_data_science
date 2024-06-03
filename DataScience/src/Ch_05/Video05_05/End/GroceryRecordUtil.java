package Ch_05.Video05_05.End;

import org.apache.commons.csv.CSVRecord;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> allMemberNumbers = new ArrayList<>(
                groceries.stream()
                    .map((grocery) -> grocery.memberNumber)
                    .collect(Collectors.toSet())
        );

        Map<String, List<GroceryRecord>> groceryRecordsByMember = new HashMap<>();

        for (String memberNumber : allMemberNumbers) {
            List<GroceryRecord> memberRecords = groceries.stream()
                    .filter((grocery) -> grocery.memberNumber == memberNumber)
                    .collect(Collectors.toList());

            groceryRecordsByMember.put(memberNumber, memberRecords);
        }

        return groceryRecordsByMember;
    }
}
