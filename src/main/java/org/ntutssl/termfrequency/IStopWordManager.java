package org.ntutssl.termfrequency;

public interface IStopWordManager {
    StopWordManager(String filePath, IOHandler ioHandler);

    boolean isStopWordList(String word);
                    
    boolean isStopWordSet(String word);
 }