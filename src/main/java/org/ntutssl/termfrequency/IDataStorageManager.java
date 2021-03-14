package org.ntutssl.termfrequency;

public interface IDataStorageManager {
    DataStorageManager(String filePath, IOHandler ioHandler);
    List<String> getWords();
 }