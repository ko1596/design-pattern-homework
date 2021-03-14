package org.ntutssl.termfrequency;

import java.util.ArrayList;
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


    @Override
    public List<String> getWordFrequency(SortOrder order) {
        List<String> outputList = new ArrayList<>();

        if(order==SortOrder.ASCENDING){
            this.words.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue())
            .forEachOrdered(x -> outputList.add(x.getKey() + ": " + x.getValue() + "\n"));
            return outputList;
        }
        else{
            this.words.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEachOrdered(x -> outputList.add(x.getKey() + ": " + x.getValue() + "\n"));
            return outputList;
        }

    }

    @Override
    public void output(String outputPath, String order, int range, IOHandler handler) {
        if(order.equals("asc") ){
            handler.handleOutput(outputPath, range, getWordFrequency(SortOrder.ASCENDING));
        }
        else if(order.equals("des")){
            handler.handleOutput(outputPath, range, getWordFrequency(SortOrder.DESCENDING));
        }else{
            throw new WordFrequencyException("The order should be \"asc\" or \"des\".");
        }
    }
}