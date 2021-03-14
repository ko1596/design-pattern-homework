package org.ntutssl.termfrequency;

public interface IWordFrequencyManager {
    void incrementCount(String word)
    int getNumOfWords();
    List<String> getWordFrequency(SortOrder order);
    void output(
        String outputPath,
        String order,
        int range,
        IOHandler handler
    )

 }
