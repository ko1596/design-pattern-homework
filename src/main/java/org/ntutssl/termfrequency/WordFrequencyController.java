package org.ntutssl.termfrequency;

import java.util.Map;
import java.util.Map.Entry;

public class WordFrequencyController{
    public static void main(String[] args){
        StopWordManager swm = new StopWordManager(args[0]);
        DataStorageManager dsm = new DataStorageManager(args[1]);
        WordFrequencyManager wfm = new WordFrequencyManager();
     }
}