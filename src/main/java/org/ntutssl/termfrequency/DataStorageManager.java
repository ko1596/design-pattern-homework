package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.List;

public class DataStorageManager implements IDataStorageManager {
    private List<String> allWords;
    
    public DataStorageManager(String filePath, IOHandler ioHandler) {
        this.allWords = new ArrayList<>();
        this.allWords = ioHandler.handleInputAsList(filePath, "[\\W_]+");
     }

    public List<String> getWords() {
        return this.allWords;
     }
}