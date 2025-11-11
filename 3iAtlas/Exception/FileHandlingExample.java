package Exception;
import java.io.*;

public class FileHandlingExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error: Problem while reading file!");
        }
    }
}

