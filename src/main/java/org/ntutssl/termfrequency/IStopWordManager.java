package org.ntutssl.termfrequency;

public interface IStopWordManager {

    boolean isStopWordList(String word);
                    
    boolean isStopWordSet(String word);
 }