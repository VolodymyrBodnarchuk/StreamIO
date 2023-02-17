import java.io.*;
import java.nio.file.*;

public class FileData{
    private String path_of_file;
    private char lookSymbol;
    public FileData(String path, char look){
        path_of_file = path;
        lookSymbol = look;
    }

    public String[] OpenAndRead() throws IOException {
        FileReader x = new FileReader(path_of_file);
        BufferedReader varRead = new BufferedReader(x);

        int num = numStrings();
        String[] lines = new String[num];

        int i;
        for(i = 0; i < num; i++){
            lines[i] = varRead.readLine();
        }

        varRead.close();
        return lines;
    }

    int numStrings() throws IOException{

        FileReader text = new FileReader(path_of_file);
        BufferedReader y = new BufferedReader(text);

        String one;
        int num = 0;

        while((one = y.readLine()) != null){
            num++;
        }
        y.close();

        return num;
    }
    public int count () throws IOException{
        int count = 0;
        try (FileReader in = new FileReader(path_of_file);
             BufferedReader reader = new BufferedReader(in))
        {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (lookSymbol == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return count;
    }
}