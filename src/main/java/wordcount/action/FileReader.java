package wordcount.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public String readFileToString(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder.toString();
    }

}
