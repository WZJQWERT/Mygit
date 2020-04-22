
import java.io.*;
import java.io.Writer;
import java.io.File;
import java.io.BufferedWriter;

public class TesterWriter {
    public static void main (String[] args){
        File  file=  new File("d:/test.txt");
        try {

            Writer writer = new BufferedWriter(new FileWriter(file) );
            String string = "国防学院";
            writer.write(string.toCharArray());
            writer.flush();
            writer.close();
        }catch  (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}


