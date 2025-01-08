package utils.others;

import java.io.FileWriter;
import java.io.IOException;
public class CreateFiletxt {
    public void createFile(String filePath, String content){
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
