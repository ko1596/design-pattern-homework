package org.ntutssl.termfrequency;

import java.util.List;

import javax.swing.SortOrder;

public interface IWordFrequencyManager {
    void incrementCount(String word);
    int getNumOfWords();
    List<String> getWordFrequency(SortOrder order);
    void output(
        String outputPath,
        String order,
        int range,
        IOHandler handler
    );

 }
