package org.ntutssl.termfrequency;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class StopWordManager implements IStopWordManager {
    private List<String> stopWordsList;
    private Set<String> stopWordsSet;
    private String nextStopWord;

    public StopWordManager(String filePath, IOHandler ioHandler) {
        this.stopWordsList = new ArrayList<>();
        this.stopWordsSet = new HashSet<>();

     }

    public boolean isStopWordList(String word) {
        if(word.length()>1) return this.stopWordsList.contains(word);
        else return true;
     }
                    
    public boolean isStopWordSet(String word) {
        if(word.length()>1) return this.stopWordsSet.contains(word);
        else return true;
     }
}