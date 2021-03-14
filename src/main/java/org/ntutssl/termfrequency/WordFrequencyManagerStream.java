package org.ntutssl.termfrequency;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.SortOrder;

public class WordFrequencyManagerStream implements IWordFrequencyManager {
    private Map<String, Integer> words;
    
    public WordFrequencyManagerStream() {
        this.words = new Hashtable<>();
    }

    public void incrementCount(String word) {
        if(this.words.containsKey(word)){
            this.words.put(word,this.words.get(word) + 1);
        }else{
            this.words.put(word, 1);
        }
     }

    public int getNumOfWords() {
        return this.words.size();
     }

    // public List<String> getWordFrequency(SortOrder order) { }

    // private List<String> sort(SortOrder order) { }

    // public void output(
    //     String outputPath,
    //     String order,
    //     int range,
    //     IOHandler handler
    // ){ }

    @Override
    public List<String> getWordFrequency(SortOrder order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void output(String outputPath, String order, int range, IOHandler handler) {
        // TODO Auto-generated method stub
        
    }
}