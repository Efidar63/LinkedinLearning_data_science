package Ch_05.Video05_05.End;

import org.apache.commons.csv.CSVRecord;

import java.util.List;
import java.util.stream.Collectors;

public class CSVLoading {
    public static void main(String[] args) {
        List<CSVRecord> records = CSVLoader.parseCSV("Groceries_dataset.csv");
        List<GroceryRecord> groceryRecords = records.stream()
                .map((record) -> GroceryRecordUtil.parseGroceryRecord(record))
                .collect(Collectors.toList());
        groceryRecords.forEach((record) -> System.out.println(record));
    }
}
