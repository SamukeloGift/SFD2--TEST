import java.io.FileWriter;
import java.io.IOException;

public class Filescript {
    public boolean Writer(String file_path, String Content){
        try (FileWriter writer = new FileWriter(file_path)) {
            writer.write(Content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }    
}
