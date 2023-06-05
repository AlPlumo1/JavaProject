package test;
import model.Reader;
import model.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class ProcessingTest {
    // Scrutinizing a particular folder for files matching the pattern
    String folderPath = "/path/to/folder";
    Reader fileProcessor = new Reader();
    Parser fileParse = new Parser();
    List<File> files = (List<File>) fileProcessor.lookFile(folderPath);
        Assertions.assertNotNull(files);
        Assertions.assertFalse(files.isEmpty());

        for (File file : files) {
        // Parsing the CSV file
        List<Record> records = fileParse.Parser(file);
        Assertions.assertNotNull(records);
        Assertions.assertFalse(records.isEmpty());

        for (Record record : records) {
            // Populating a relational database with the entries
            boolean success = fileProcessor.populateDatabase(record);
            Assertions.assertTrue(success);
        }

        // Moving processed files to another folder
        String destinationFolder = "/path/to/processed";
        boolean moved = fileProcessor.moveFile(file, destinationFolder);
        Assertions.assertTrue(moved);
    }
}
}
