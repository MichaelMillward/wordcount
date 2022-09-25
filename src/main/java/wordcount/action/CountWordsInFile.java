package wordcount.action;

import wordcount.exception.UnableToWriteOrderedWordCountsException;
import wordcount.model.OrderedWordCounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CountWordsInFile {

    FileReader fileReader;

    WordCounter wordCounter;

    OrderedWordCountsWriter orderedWordCountsWriter;
    public CountWordsInFile() {
        this.fileReader = new FileReader();
        this.wordCounter = new WordCounter();
        this.orderedWordCountsWriter = new OrderedWordCountsWriter();
    }
    public void run(String pathToFile) throws FileNotFoundException, UnableToWriteOrderedWordCountsException {
        String fileContents = this.fileReader.readFileToString(pathToFile);

        OrderedWordCounts orderedWordCounts = this.wordCounter.get(fileContents);

        try (Writer writer = new OutputStreamWriter(System.out)) {
            this.orderedWordCountsWriter.write(writer, orderedWordCounts);
        } catch (IOException ex) {
            throw new UnableToWriteOrderedWordCountsException();
        }
    }

}
