import java.io.IOException;
import java.io.FileWriter;
public class WriteToFile {
    public static void writeToFile(String fileName, String data) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        }
    }
}
