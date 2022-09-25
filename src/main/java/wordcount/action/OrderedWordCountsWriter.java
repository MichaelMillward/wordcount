package wordcount.action;

import wordcount.model.OrderedWordCounts;
import wordcount.model.WordCount;

import java.io.IOException;
import java.io.Writer;

public class OrderedWordCountsWriter {
    private static final String WORD_COUNT_FORMAT = "%s: %d%n";
    public void write(Writer writer, OrderedWordCounts wordCounts) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (WordCount wordCount: wordCounts.getWordCounts()) {
            String line = String.format(WORD_COUNT_FORMAT, wordCount.getWord(), wordCount.getCount());
            sb.append(line);
        }
        String contents = sb.toString();
        writer.write(contents);
    }

}
