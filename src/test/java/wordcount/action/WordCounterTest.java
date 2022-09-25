package wordcount.action;

import org.junit.Assert;
import org.junit.Test;
import wordcount.model.OrderedWordCounts;
import wordcount.model.WordCount;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    @Test
    public void testWordWithMultiplePunctuation() {
        OrderedWordCounts orderedWordCounts = wordCounter.get("Hello, why hello there hello.");
        assertOrderedWordCountsHas(orderedWordCounts, "hello", 3);
    }

    @Test
    public void testAccentedCharacters() {
        OrderedWordCounts orderedWordCounts = wordCounter.get("âme île hôtel sûr être");
        assertOrderedWordCountsHas(orderedWordCounts, "hôtel", 1);
    }


    @Test
    public void testOrdering() {
        OrderedWordCounts orderedWordCounts = wordCounter.get("Three three three. Two two. One.");
        List<WordCount> wordCounts = orderedWordCounts.getWordCounts();
        Assert.assertEquals(3, wordCounts.size());

        Assert.assertEquals("three", wordCounts.get(0).getWord());
        Assert.assertEquals(3, wordCounts.get(0).getCount());

        Assert.assertEquals("two", wordCounts.get(1).getWord());
        Assert.assertEquals(2, wordCounts.get(1).getCount());

        Assert.assertEquals("one", wordCounts.get(2).getWord());
        Assert.assertEquals(1, wordCounts.get(2).getCount());
    }

    @Test
    public void testCasesForEnglishLocale() {
        Locale.setDefault(new Locale("en", "NZ"));
        OrderedWordCounts orderedWordCounts = wordCounter.get("Hotel hotel");
        assertOrderedWordCountsHas(orderedWordCounts, "hotel", 2);

    }

    @Test
    public void testCasesForNonEnglishLocale() {
        Locale.setDefault(new Locale("tr", "TR"));
        OrderedWordCounts orderedWordCounts = wordCounter.get("Islama köfte ıslama");
        assertOrderedWordCountsHas(orderedWordCounts, "ıslama", 2);
    }

    private static void assertOrderedWordCountsHas(OrderedWordCounts orderedWordCounts, String word, int count) {
        List<WordCount> wordCounts = orderedWordCounts.getWordCounts().stream()
                .filter(w -> w.getWord().equals(word))
                .collect(Collectors.toList());

        Assert.assertEquals( 1, wordCounts.size());

        WordCount wordCount = wordCounts.get(0);

        Assert.assertEquals(wordCount.getWord(), word);
        Assert.assertEquals(wordCount.getCount(), count);
    }

}
