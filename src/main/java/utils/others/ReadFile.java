package utils.others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadFile {
    public void readFile(String filePath, List<String> lines) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
