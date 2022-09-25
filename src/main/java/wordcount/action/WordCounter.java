package wordcount.action;

import wordcount.model.OrderedWordCounts;
import wordcount.model.WordCount;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {

    private static final String WORD_REGEX = "[^\\p{IsAlphabetic}0-9']+";

    public OrderedWordCounts get(String contents) {
        Map<String, Integer> wordsToCount = new HashMap<>();
        String[] words = contents.split(WORD_REGEX);

        for (String word: words) {
            word = word.toLowerCase();
            int count = wordsToCount.getOrDefault(word, 0);
            wordsToCount.put(word, ++count);
        }

        List<WordCount> wordCounts = wordsToCount.entrySet()
                .stream()
                .map(entry -> new WordCount(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(WordCount::getCount).reversed())
                .collect(Collectors.toList());

        return new OrderedWordCounts(wordCounts);
    }

}
