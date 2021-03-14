package org.ntutssl.termfrequency;

public class WordFrequencyManagerStream implements IWordFrequencyManager {
    public WordFrequencyManagerStream() { }

    public void incrementCount(String word) { }

    public int getNumOfWords() { }

    public List<String> getWordFrequency(SortOrder order) { }

    private List<String> sort(SortOrder order) { }

    public void output(
        String outputPath,
        String order,
        int range,
        IOHandler handler
    ){ }
}