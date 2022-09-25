package wordcount;

import wordcount.action.CountWordsInFile;
import wordcount.exception.UnableToWriteOrderedWordCountsException;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Program must be run with the following arguments - pathToFile");
        }

        String pathToFile = args[0];

        try {
            new CountWordsInFile().run(pathToFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find file at path: " + pathToFile);
            System.exit(1);
        } catch (UnableToWriteOrderedWordCountsException ex) {
            System.out.println("Unable to write the ordered word counts");
            System.exit(1);
        }
    }

}
