package wordcount.model;

import java.util.List;

public class OrderedWordCounts {

    private final List<WordCount> wordCounts;

    public OrderedWordCounts(List<WordCount> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public List<WordCount> getWordCounts() {
        return wordCounts;
    }

}
