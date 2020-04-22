
import java.io.*;
import java.io.BufferedReader;
import java.io.Reader;
public class TesterReader {

    public static void main(String[] args) {
        File file = new File("d:/test.txt");
        try {

            Reader reader = new BufferedReader(new FileReader(file));
            char[] data = new char[1];
            int len = 0;
            while (-1 != (len = reader.read(data))) {
                System.out.println(new String(data, 0, 1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


