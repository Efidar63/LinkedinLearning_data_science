package Ch_04.Video04_09.Start;

import org.apache.commons.csv.CSVRecord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroceryRecordUtilChallenge {
    public static void main(String[] args) {
        List<CSVRecord> records = CSVLoader.parseCSV("Groceries_dataset.csv");
        List<GroceryRecord> groceryRecords = records.stream()
                .map((record) -> GroceryRecordUtil.parseGroceryRecord(record))
                .collect(Collectors.toList());

        // Implement this:
        Map<String, List<GroceryRecord>> recordsByMemberNumber =
                GroceryRecordUtil.groupGroceryRecordsByMemberNumber(groceryRecords);

        System.out.println(recordsByMemberNumber);
    }
}
