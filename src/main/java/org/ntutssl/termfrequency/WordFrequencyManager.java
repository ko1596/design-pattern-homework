package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.SortOrder;

public class WordFrequencyManager implements IWordFrequencyManager {
    private Map<String, Integer> words;
    
    public WordFrequencyManager() {
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


     public List<String> getWordFrequency(SortOrder order) {
         List<Map.Entry<String, Integer>> list = new ArrayList<>(this.words.entrySet());
         List<String> outputList = new ArrayList<>();
 
         if(order==SortOrder.ASCENDING){
             Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
                 @Override
                 public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                     return o1.getValue().compareTo(o2.getValue());
                 }
             });
         }
         else if(order==SortOrder.DESCENDING){
             Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
                 @Override
                 public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                     return o2.getValue().compareTo(o1.getValue());
                 }
             });
         }
 
         for(Map.Entry<String, Integer> map: list){
             outputList.add(map.getKey() + ": " + map.getValue() + "\n");
         }
         System.out.println(outputList);
         return outputList;
 
     }

    public void output(String outputPath, String order, int range, IOHandler handler) {
        if(getNumOfWords()==0){
            throw new WordFrequencyException("Word not found.");
        }else if(range<1||range>getNumOfWords()){
            throw new WordFrequencyException("Out of range! The range should be from 1 to "+getNumOfWords()+".");
        }
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