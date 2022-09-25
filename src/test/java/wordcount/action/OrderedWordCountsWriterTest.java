package wordcount.action;

import org.junit.Assert;
import org.junit.Test;
import wordcount.model.OrderedWordCounts;
import wordcount.model.WordCount;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class OrderedWordCountsWriterTest {

    private final OrderedWordCountsWriter orderedWordCountsWriter = new OrderedWordCountsWriter();

    @Test
    public void testWriteSuccess() throws IOException {
        OrderedWordCounts orderedWordCounts = createOrderedWordCounts();

        String output;
        try (Writer writer = new StringWriter()) {
            this.orderedWordCountsWriter.write(writer, orderedWordCounts);
            output =  writer.toString();
        }

        Assert.assertEquals("hello: 2\nworld: 1\n", output);
    }

    private OrderedWordCounts createOrderedWordCounts() {
        WordCount wordCount1 = new WordCount("hello", 2);
        WordCount wordCount2 =  new WordCount("world", 1);
        List<WordCount> wordCounts = Arrays.asList(wordCount1, wordCount2);
        return new OrderedWordCounts(wordCounts);
    }



}
